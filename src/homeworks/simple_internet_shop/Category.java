package homeworks.simple_internet_shop;

public enum Category {
    COMPUTERS("Computers"),
    PHONES("Mobile Phones "),
    PRINTERS("Printers"),
    TVS("TVs"),
    UNCLASSIFIED("unknown");

    private String shortName;

    Category(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return shortName;
    }
}
