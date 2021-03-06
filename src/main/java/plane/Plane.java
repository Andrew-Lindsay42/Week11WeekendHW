package plane;

public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getType() {
        return planeType;
    }

    public int getCapacity(){
        return planeType.getCapacity();
    }

    public int getWeight(){
        return planeType.getWeight();
    }

    public double getBaggageSpace() {
        return getWeight() / 2.0;
    }
}
