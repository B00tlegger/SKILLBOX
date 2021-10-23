import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Line implements Comparable<Line> {
    private int number;
    private String name;
    private List<String> stations;

    public Line(int number, String name) {
        this.number = number;
        this.name = name;
        stations = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void addStations(JSONObject object) {
        JSONObject lineStations = (JSONObject) object.get("stations");
        lineStations.keySet().forEach(o -> {
            int lineNumber = Integer.parseInt((String) o);
            JSONArray jsonArray = (JSONArray) lineStations.get(o);
            if (lineNumber == number) {
                jsonArray.forEach(station -> stations.add(station.toString()));
            }
        });
    }

    public List<String> getStations() {
        return stations;
    }

    @Override
    public int compareTo(Line line) {
        return Integer.compare(number, line.getNumber());
    }

    public boolean equals(Object o) {
        return compareTo((Line) o) == 0;
    }
}
