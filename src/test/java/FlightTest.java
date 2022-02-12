import org.junit.Before;
import org.junit.Test;
import people.CabinCrew;
import people.Passenger;
import people.Pilot;
import people.Rank;
import plane.Plane;
import plane.PlaneType;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {
    Flight flight;
    Pilot pilot;
    ArrayList<CabinCrew> cabinCrew;
    Plane plane;
    Passenger passenger;

    @Before
    public void before(){
        pilot = new Pilot("Greg", Rank.CAPTAIN, "ABC123");
        cabinCrew = new ArrayList<>();
        cabinCrew.add(new CabinCrew("Tim", Rank.CABIN_CREW));
        cabinCrew.add(new CabinCrew("Rebecca", Rank.PURSER));
        plane = new Plane(PlaneType.CESSNA_172);
        flight = new Flight(pilot, cabinCrew, plane, "ZT141", "FRA", "EDI", "12:30");
        passenger = new Passenger("Andrew", 2);
    }

    @Test
    public void hasPilot(){
        assertEquals(pilot, flight.getPilot());
    }

    @Test
    public void hasCabinCrew(){
        assertEquals(cabinCrew, flight.getCabinCrew());
    }

    @Test
    public void hasPlane(){
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("ZT141", flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals("FRA", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport(){
        assertEquals("EDI", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime(){
        assertEquals("12:30", flight.getDepartureTime());
    }

    @Test
    public void passengersStartAtZero(){
        assertEquals(0, flight.countPassengers());
    }

    @Test
    public void canGetAvailableSeats(){
        assertEquals(4, flight.countAvailableSeats());
    }

    @Test
    public void canBookPassenger(){
        assertTrue(flight.bookPassenger(passenger));
    }

    @Test
    public void cannotBookPassengerIfFull(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        assertFalse(flight.bookPassenger(passenger));
    }
}
