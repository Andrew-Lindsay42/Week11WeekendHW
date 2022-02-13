package plane;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.BOEING_747);
    }

    @Test
    public void hasType(){
        assertEquals(PlaneType.BOEING_747, plane.getType());
    }

    @Test
    public void hasCapacity(){
        assertEquals(524, plane.getCapacity());
    }

    @Test
    public void hasWeight(){
        assertEquals(183500, plane.getWeight());
    }

    @Test
    public void canGetBaggageSpace(){
        assertEquals(91750, plane.getBaggageSpace(), 0);
    }

}
