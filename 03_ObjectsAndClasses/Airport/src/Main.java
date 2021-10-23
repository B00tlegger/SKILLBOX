import com.skillbox.airport.Airport;

public class Main
{
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        System.out.println("Все судна: " + airport.getAllAircrafts().size());

        int aircraftList = airport.getAllAircrafts().size();
        System.out.println(aircraftList);


    }
}