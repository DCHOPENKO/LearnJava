package homeworks.jdbc;

public enum Qualification {
    FRESH("fresh"),
    EXPERT("expert"),
    N_A("not acceptable value");

    private String shortName;

    Qualification(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
