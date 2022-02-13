package flight;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import people.CabinCrew;
import people.Passenger;
import people.Pilot;
import people.Rank;
import plane.Plane;
import plane.PlaneType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FlightTest {
    Flight flight;
    Pilot pilot;
    ArrayList<CabinCrew> cabinCrew;
    Plane plane;
    Passenger passenger;
    LocalDateTime departureTime;

    @Before
    public void before(){
        departureTime = LocalDateTime.of(LocalDate.of(2021, 2, 13), LocalTime.of(12,30));
        pilot = new Pilot("Greg", Rank.CAPTAIN, "ABC123");
        cabinCrew = new ArrayList<>();
        cabinCrew.add(new CabinCrew("Tim", Rank.CABIN_CREW));
        cabinCrew.add(new CabinCrew("Rebecca", Rank.PURSER));
        plane = new Plane(PlaneType.CESSNA_172);
        flight = new Flight(pilot, cabinCrew, plane, "ZT141", "FRA", "EDI", departureTime);
        passenger = new Passenger("Andrew", 2);
    }

    @Test
    public void hasPilot(){
        Assert.assertEquals(pilot, flight.getPilot());
    }

    @Test
    public void hasCabinCrew(){
        Assert.assertEquals(cabinCrew, flight.getCabinCrew());
    }

    @Test
    public void hasPlane(){
        Assert.assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber(){
        Assert.assertEquals("ZT141", flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        Assert.assertEquals("FRA", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport(){
        Assert.assertEquals("EDI", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime(){
        Assert.assertEquals(departureTime, flight.getDepartureTime());
    }

    @Test
    public void passengersStartAtZero(){
        Assert.assertEquals(0, flight.countPassengers());
    }

    @Test
    public void canGetAvailableSeats(){
        Assert.assertEquals(4, flight.countAvailableSeats());
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

    @Test
    public void givesEachPassengerUniqueSeat(){
        flight.bookPassenger(passenger);
        passenger = new Passenger("Andrew", 2);
        flight.bookPassenger(passenger);
        passenger = new Passenger("Andrew", 2);
        flight.bookPassenger(passenger);
        passenger = new Passenger("Andrew", 2);
        flight.bookPassenger(passenger);
        ArrayList<Integer> seatList = new ArrayList<>();
        for (Passenger passenger : flight.getPassengers()) {
            seatList.add(passenger.getSeatNumber());
        }
        HashSet<Integer> seatListNoDupes = new HashSet<>(seatList);
        assertEquals(seatList.size(), seatListNoDupes.size());
    }
}
