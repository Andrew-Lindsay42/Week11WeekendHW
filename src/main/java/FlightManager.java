public class FlightManager {
    public FlightManager(){
    }

    public double baggagePerPassenger(Flight flight) {
        double baggageSpace = flight.getPlane().getBaggageSpace();
        double capacity = flight.getPlane().getCapacity();
        return baggageSpace / capacity;
    }

    public double baggageBooked(Flight flight) {
        double baggagePerPassenger = baggagePerPassenger(flight);
        double passengersBooked = flight.countPassengers();
        return baggagePerPassenger * passengersBooked;
    }

    public double baggageRemaining(Flight flight) {
        double baggageSpace = flight.getPlane().getBaggageSpace();
        return baggageSpace - baggageBooked(flight);
    }
}
