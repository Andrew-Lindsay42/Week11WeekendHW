package people;

import flight.Flight;

public class Passenger extends Person{
    private int bags;
    private Flight flight;
    private Integer seatNumber;

    public Passenger(String name, int bags) {
        super(name);
        this.bags = bags;
        this.flight = null;
        this.seatNumber = null;
    }

    public int getBags() {
        return bags;
    }

    public Flight getFlight() {
        return flight;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
