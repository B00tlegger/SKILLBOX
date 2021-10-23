import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class MetroMap {

    private final Document document;
    private final Elements elements;
    private List<Line> metroLines;
    private List<Station> metroStations;
    private Station station;
    private Line line;


    public MetroMap(String URL) {
        document = getUrl(URL);
        elements = document.select("span.js-metro-line");
        createMetroLines();
        createStations();
        addConnectionStations();
    }

    public static Document getUrl(String URL) {
        Document document = null;
        try {
            document = Jsoup.connect(URL).maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Document getDocument() {
        return document;
    }

    private void createMetroLines() {
        metroLines = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            line = new Line(i + 1, elements.get(i).text());
            metroLines.add(line);
        }
    }

    public List<Line> getMetroLines() {
        return metroLines;
    }

    private void createStations() {
        metroStations = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            for (String s : addStations(document).get(i)) {
                station = new Station(metroLines.get(i), s.trim());
                metroStations.add(station);
            }

        }

    }

    public List<Station> getMetroStations() {
        return metroStations;
    }

    private List<String[]> addStations(Document document) {
        List<String[]> list = new ArrayList<>();
        Elements elements = document.select("div[^data-line]");
        elements.forEach(element -> {
            if (!element.select("div[^data-line]").text().equals("")) {
                String string = element.text().replaceFirst("1. ", "").trim();
                String[] strings = string.split("[0-9]*\\.\s");
                list.add(strings);
            }
        });
        return list;
    }

    public void addConnectionStations() {
        Elements elements = document.select("div[id=\"metrodata\"]").select("a[data-metrost]");
        for (Element element : elements) {
            if (element.select(".t-icon-metroln").hasClass("t-icon-metroln")) {
                for (Station station1 : metroStations) {
                    if (station1.getName().equalsIgnoreCase(element.select("span.name").text().trim())) {
                        List<Station> connections = new ArrayList<>();
                        String transferStation = element.select(".t-icon-metroln").toString().replaceAll(".*«", "").replaceAll("».*", "");
                        String[] transferStations = transferStation.split("\n");
                        for (String string : transferStations) {
                            for (Station station2 : metroStations) {
                                if (station2.getName().equalsIgnoreCase(string) && station2.compareTo(station1) != 0 && !connections.contains(station2)) {
                                    connections.add(station2);
                                }
                            }
                            station1.addConnections(connections);
                        }
                    }
                }
            }
        }
    }
}