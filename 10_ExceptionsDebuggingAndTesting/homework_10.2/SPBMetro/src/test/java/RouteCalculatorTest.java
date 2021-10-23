import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex;
    List<Station> route;
    List<Station> connectionStations;
    RouteCalculator calculator;

    @Override
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();
        connectionStations = new ArrayList<>();

        Line line1 = new Line(1 , "One");
        stationIndex.addLine(line1);
        Line line2 = new Line(2 , "Two");
        stationIndex.addLine(line2);
        Line line3 = new Line(3 , "Three");
        stationIndex.addLine(line3);

        stationIndex.addStation(new Station("1-1" , line1));
        stationIndex.addStation(new Station("1-2", line1));
        stationIndex.addStation(new Station("1-3", line1));
        stationIndex.addStation(new Station("2-1" , line2));
        stationIndex.addStation(new Station("2-2", line2));
        stationIndex.addStation(new Station("3-1", line3));
        stationIndex.addStation(new Station("3-2", line3));

        stationIndex.getLine(1).addStation(stationIndex.getStation("1-1"));
        stationIndex.getLine(1).addStation(stationIndex.getStation("1-2"));
        stationIndex.getLine(1).addStation(stationIndex.getStation("1-3"));
        stationIndex.getLine(2).addStation(stationIndex.getStation("2-1"));
        stationIndex.getLine(2).addStation(stationIndex.getStation("2-2"));
        stationIndex.getLine(3).addStation(stationIndex.getStation("3-1"));
        stationIndex.getLine(3).addStation(stationIndex.getStation("3-2"));

        connectionStations.add(stationIndex.getStation("1-2"));
        connectionStations.add(stationIndex.getStation("2-1"));
        stationIndex.addConnection(connectionStations);
        connectionStations.clear();

        connectionStations.add(stationIndex.getStation("2-2"));
        connectionStations.add(stationIndex.getStation("3-1"));
        stationIndex.addConnection(connectionStations);

        route = new ArrayList<>();

        calculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration()
    {
        route.add(stationIndex.getStation("1-1"));
        route.add(stationIndex.getStation("1-2"));
        route.add(stationIndex.getStation("2-1"));
        route.add(stationIndex.getStation("2-2"));
        route.add(stationIndex.getStation("3-1"));
        route.add(stationIndex.getStation("3-2"));

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute()
    {
        connectionStations.add(stationIndex.getStation("2-1"));
        connectionStations.add(stationIndex.getStation("3-1"));
        stationIndex.addConnection(connectionStations);
        connectionStations.clear();

        List<Station> routeActual = calculator.getShortestRoute(stationIndex.getStation("1-1"), stationIndex.getStation("3-2"));
        List<Station> routeExpected = new ArrayList<>();
        routeExpected.add(stationIndex.getStation("1-1"));
        routeExpected.add(stationIndex.getStation("1-2"));
        routeExpected.add(stationIndex.getStation("2-1"));
        routeExpected.add(stationIndex.getStation("3-1"));
        routeExpected.add(stationIndex.getStation("3-2"));
        assertEquals(routeExpected , routeActual);

    }

    public void testGetRouteOnTheLine()
    {
        List<Station> routeActual = calculator.getShortestRoute(stationIndex.getStation("1-1"), stationIndex.getStation("1-3"));
        List<Station> routeExpected = new ArrayList<>();
        routeExpected.add(stationIndex.getStation("1-1"));
        routeExpected.add(stationIndex.getStation("1-2"));
        routeExpected.add(stationIndex.getStation("1-3"));
        assertEquals(routeExpected , routeActual);
    }

    public void testGetRouteWithOneConnection()
    {
        List<Station> routeActual = calculator.getShortestRoute(stationIndex.getStation("1-1"), stationIndex.getStation("2-1"));
        List<Station> routeExpected = new ArrayList<>();
        routeExpected.add(stationIndex.getStation("1-1"));
        routeExpected.add(stationIndex.getStation("1-2"));
        routeExpected.add(stationIndex.getStation("2-1"));
        assertEquals(routeExpected , routeActual);
    }

    public void testGetRouteWithTwoConnections()
    {
        List<Station> routeActual = calculator.getShortestRoute(stationIndex.getStation("1-1"), stationIndex.getStation("3-2"));
        List<Station> routeExpected = new ArrayList<>();
        routeExpected.add(stationIndex.getStation("1-1"));
        routeExpected.add(stationIndex.getStation("1-2"));
        routeExpected.add(stationIndex.getStation("2-1"));
        routeExpected.add(stationIndex.getStation("2-2"));
        routeExpected.add(stationIndex.getStation("3-1"));
        routeExpected.add(stationIndex.getStation("3-2"));
        assertEquals(routeExpected , routeActual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
