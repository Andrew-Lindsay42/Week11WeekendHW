package people;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {
    Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot("Greg", Rank.CAPTAIN, "ABC123");
    }

    @Test
    public void hasName(){
        assertEquals("Greg", pilot.getName());
    }

    @Test
    public void hasRank(){
        assertEquals(Rank.CAPTAIN, pilot.getRank());
    }

    @Test
    public void hasLicenceNumber(){
        assertEquals("ABC123", pilot.getLicenceNumber());
    }

    @Test
    public void canFlyPlane(){
        assertEquals("Neeeeowww", pilot.flyPlane());
    }
}
