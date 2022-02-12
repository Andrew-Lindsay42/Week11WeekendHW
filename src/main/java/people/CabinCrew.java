package people;

public class CabinCrew extends Staff{

    public CabinCrew(String name, Rank rank) {
        super(name, rank);
    }

    public String giveBriefing(){
        return "The emergency exits are located .... etc";
    }
}
