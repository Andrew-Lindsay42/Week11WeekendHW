package people;

import org.junit.Before;
import org.junit.Test;
import plane.Plane;
import plane.PlaneType;
import flight.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PassengerTest {
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
        plane = new Plane(PlaneType.CESSNA_172);
        flight = new Flight(pilot, cabinCrew, plane, "ZT141", "FRA", "EDI", departureTime);
        passenger = new Passenger("Andrew", 2);
    }

    @Test
    public void hasName(){
        assertEquals("Andrew", passenger.getName());
    }

    @Test
    public void hasBags(){
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void flightStartsNull(){
        assertNull(passenger.getFlight());
    }

    @Test
    public void whenBookedOnFlightPropertyAssigned(){
        flight.bookPassenger(passenger);
        assertEquals(flight, passenger.getFlight());
    }
}
