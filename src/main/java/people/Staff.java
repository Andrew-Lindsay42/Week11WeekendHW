package people;

public abstract class Staff extends Person{
    private Rank rank;

    public Staff(String name, Rank rank) {
        super(name);
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

}
