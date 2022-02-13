import org.junit.Before;
import org.junit.Test;
import people.CabinCrew;
import people.Passenger;
import people.Pilot;
import people.Rank;
import plane.Plane;
import plane.PlaneType;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Pilot pilot;
    ArrayList<CabinCrew> cabinCrew;
    Plane plane;
    Passenger passenger;

    @Before
    public void before(){
        flightManager = new FlightManager;
        pilot = new Pilot("Greg", Rank.CAPTAIN, "ABC123");
        cabinCrew = new ArrayList<>();
        plane = new Plane(PlaneType.CESSNA_172);
        flight = new Flight(pilot, cabinCrew, plane, "ZT141", "FRA", "EDI", "12:30");
        passenger = new Passenger("Andrew", 2);
    }

    @Test
    public void canCalculateWeightPerPassenger(){
        assertEquals(94.75, flightManager.baggagePerPassenger(flight), 0.0);
    }

    @Test
    public void canCalculateWeightAlreadyBooked(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        assertEquals(189.5, flight.baggageBooked(), 0.0);
    }

    @Test
    public void canCalculateWeightRemaining(){
        assertEquals(379.0, flight.baggageRemaining(), 0.0);
    }
}
