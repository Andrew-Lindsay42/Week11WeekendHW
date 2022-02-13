package people;

import flight.Flight;

public class Passenger extends Person{
    private int bags;
    private Flight flight;

    public Passenger(String name, int bags) {
        super(name);
        this.bags = bags;
        this.flight = null;
    }

    public int getBags() {
        return bags;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
