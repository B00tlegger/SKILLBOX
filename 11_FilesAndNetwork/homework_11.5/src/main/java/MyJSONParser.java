import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyJSONParser {
    public MetroMap metroMap;

    public MyJSONParser(MetroMap metroMap) {
        this.metroMap = metroMap;
    }

    public void writeFile(String path) {
        try (FileWriter file = new FileWriter(path)
        ) {
            file.write(getMetroData().toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONArray getMetroLines() {
        JSONArray array = new JSONArray();
        for (Line line : metroMap.getMetroLines()) {
            JSONObject metroLine = new JSONObject();
            metroLine.put("number", line.getNumber());
            metroLine.put("name", line.getName());
            array.add(metroLine);
        }
        return array;
    }

    private JSONObject getMetroStations() {
        JSONObject obj = new JSONObject();
        for (int i = metroMap.getMetroLines().size() - 1; i >= 0; i--) {
            JSONArray jsonArray = new JSONArray();
            for (Station station : metroMap.getMetroStations()) {
                if (station.getLine().getNumber() == i + 1) {
                    jsonArray.add(station.getName());
                }
            }
            obj.put(i + 1, jsonArray);
        }
        return obj;
    }

    public JSONArray getConnectionStations() {
        JSONArray connections = new JSONArray();
        JSONArray connect = null;
        for (Station station1 : metroMap.getMetroStations()) {
            if (station1.getConnection() != null) {
                connect = new JSONArray();
                JSONObject stationOne = new JSONObject();
                stationOne.put("line", station1.getLine().getNumber());
                stationOne.put("station", station1.getName());
                connect.add(stationOne);
                for (Station station2 : station1.getConnection()) {
                    JSONObject stationTwo = new JSONObject();
                    stationTwo.put("line", station2.getLine().getNumber());
                    stationTwo.put("station", station2.getName());
                    connect.add(stationTwo);
                }
            }
            connect.sort(Comparator.comparing(Object::toString));
            if (connect.size() > 1 && !connections.contains(connect)) {
                connections.add(connect);
            }
        }
        return connections;
    }

    private JSONObject getMetroData() {
        JSONObject metroData = new JSONObject();
        metroData.put("stations", getMetroStations());
        metroData.put("connections", getConnectionStations());
        metroData.put("lines", getMetroLines());
        return metroData;
    }

    public static String getJsonFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static Map<Integer, Line> addLines(JSONObject object) {
        Map<Integer, Line> metroLines = new HashMap<>();
        JSONArray lines = (JSONArray) object.get("lines");
        lines.forEach(o -> {
            Line line = new Line(((Long) ((JSONObject) o).get("number")).intValue(), (String) ((JSONObject) o).get("name"));
            metroLines.put(line.getNumber(), line);
        });
        return metroLines;
    }
}
