import java.util.ArrayList;
import java.util.List;

public class Station implements Comparable<Station>{
    private Line line;
    private String name;
    private List<Station> connection = null;

    public Station(Line line , String name){
        this.line = line;
        this.name = name;
    }

    public Line getLine(){
        return line;
    }

    public String getName(){
        return  name;
    }

    public void addConnections(List<Station> connections){
        connection = new ArrayList<>();
        connection.addAll(connections);
    }

    public List<Station> getConnection() throws NullPointerException {
        return connection;
    }

    @Override
    public int compareTo(Station station) {
        int compare = line.compareTo(station.getLine());
        if (compare != 0 ){
            return compare;
        }
        return name.compareToIgnoreCase(station.getName());
    }
}

