import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        System.out.println(findPlanesLeavingInTheNextTwoHours(airport));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date date1 = new Date();
        Calendar date2 = new GregorianCalendar();
        date2.add(Calendar.HOUR_OF_DAY, +2);

        List flights = new ArrayList();
        for (int i = 0; i < airport.getTerminals().size(); i++) {

            flights.addAll(airport.getTerminals().get(i).getFlights().stream()
                    .filter(flight -> flight.getDate().before(date2.getTime()))
                    .filter(flight -> flight.getDate().after(date1))
                    .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                    .collect(Collectors.toList()));
        }

        return flights;
    }

}