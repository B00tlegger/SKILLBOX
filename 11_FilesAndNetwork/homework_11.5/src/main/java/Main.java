import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Map;

public class Main {
    private static Map<Integer, Line> linesMap;

    public static void main(String[] args) {
        MyJSONParser myJASONParser = new MyJSONParser(new MetroMap("https://www.moscowmap.ru/metro.html#lines"));
        myJASONParser.writeFile("data/Mos_Metro.json");
//        ============================================================================
        JSONParser parser = new JSONParser();
        JSONObject metroMap = new JSONObject();
        try {
            metroMap = (JSONObject) parser.parse(myJASONParser.getJsonFile("data/Mos_Metro.json"));
            linesMap = myJASONParser.addLines(metroMap);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < linesMap.size(); i++) {
            linesMap.get(i + 1).addStations(metroMap);
            System.out.println("На ветке метро " + "\"" + linesMap.get(i + 1).getName() + "\"" + " " + linesMap.get(i + 1).getStations().size() + " станций");
        }
    }
}