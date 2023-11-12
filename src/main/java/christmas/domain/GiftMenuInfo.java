package christmas.domain;

public class GiftMenuInfo {

    private final String name;
    private final int counts;

    public GiftMenuInfo(String name, int counts) {
        this.name = name;
        this.counts = counts;
    }


    public String getName() {
        return name;
    }

    public int getCounts() {
        return counts;
    }
}
