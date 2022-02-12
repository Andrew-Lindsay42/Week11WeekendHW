package people;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewTest {
    CabinCrew cabinCrew;

    @Before
    public void before(){
        cabinCrew = new CabinCrew("Tim", Rank.CABIN_CREW);
    }

    @Test
    public void hasName(){
        assertEquals("Tim", cabinCrew.getName());
    }

    @Test
    public void hasRank(){
        assertEquals(Rank.CABIN_CREW, cabinCrew.getRank());
    }

    @Test
    public void canGiveBriefing(){
        assertEquals("The emergency exits are located .... etc", cabinCrew.giveBriefing());
    }
}
