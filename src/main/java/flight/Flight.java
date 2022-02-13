package flight;

import people.CabinCrew;
import people.Passenger;
import people.Pilot;
import plane.Plane;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Flight {

    private Pilot pilot;
    private ArrayList<CabinCrew> cabinCrew;
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private LocalDateTime departureTime;
    private ArrayList<Integer> freeSeats;

    public Flight(Pilot pilot, ArrayList<CabinCrew> cabinCrew, Plane plane, String flightNumber, String destination, String departureAirport, LocalDateTime departureTime) {
        this.pilot = pilot;
        this.cabinCrew = cabinCrew;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.freeSeats = new ArrayList<>(plane.getCapacity());
        for (int i = 1; i <= plane.getCapacity(); i++) {
            freeSeats.add(i);
        }
    }

    public Pilot getPilot() {
        return pilot;
    }

    public ArrayList<CabinCrew> getCabinCrew() {
        return cabinCrew;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int countPassengers() {
        return passengers.size();
    }

    public int countAvailableSeats() {
        return freeSeats.size();
    }

    public Integer createNewSeatNum(){
        int randomIndex = new Random().nextInt(freeSeats.size());
        Integer newSeat = freeSeats.get(randomIndex);
        freeSeats.remove(randomIndex);

        return newSeat;
    }

    public boolean bookPassenger(Passenger passenger){
        if (countAvailableSeats() > 0){
            passenger.setFlight(this);
            passenger.setSeatNumber(createNewSeatNum());
            passengers.add(passenger);
            return true;
        }
        return false;
    }
}
