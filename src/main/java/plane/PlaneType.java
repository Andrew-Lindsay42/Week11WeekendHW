package plane;

public enum PlaneType {
    AIRBUS_330_300(270, 181840),
    ATR_72(72, 13500),
    BOEING_747(524, 183500),
    BOEING_737(170, 41410),
    CESSNA_172(4, 757),
    CONCORDE(100, 78700),
    EMBRAER_190(98, 27750),
    MD_11(350, 128800);

    private final int capacity;
    private final int weight;

    PlaneType(int capacity, int weight){
        this.capacity = capacity;
        this.weight = weight;
    }
}
