package flight;

import org.junit.Assert;
import org.junit.Before;
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

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Pilot pilot;
    ArrayList<CabinCrew> cabinCrew;
    Plane plane;
    Passenger passenger;
    LocalDateTime departureTime;

    @Before
    public void before(){
        flightManager = new FlightManager();
        pilot = new Pilot("Greg", Rank.CAPTAIN, "ABC123");
        cabinCrew = new ArrayList<>();
        plane = new Plane(PlaneType.CESSNA_172);
        departureTime = LocalDateTime.of(LocalDate.of(2021, 2, 13), LocalTime.of(12,30));
        flight = new Flight(pilot, cabinCrew, plane, "ZT141", "FRA", "EDI", departureTime);
        passenger = new Passenger("Andrew", 2);
    }

    @Test
    public void canCalculateWeightPerPassenger(){
        Assert.assertEquals(94.75, flightManager.baggagePerPassenger(flight), 0.0);
    }

    @Test
    public void canCalculateWeightAlreadyBooked(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        Assert.assertEquals(189.5, flightManager.baggageBooked(flight), 0.0);
    }

    @Test
    public void canCalculateWeightRemaining(){
        Assert.assertEquals(379.0, flightManager.baggageRemaining(flight), 0.0);
    }
}
