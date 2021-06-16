package homeworks.basic_tasks.vehicles;

public enum Fuel {
    GASOLINE("gasoline"),
    DIESEL("diesel"),
    ELECTRICITY("electricity"),
    NOTSET ("no engine");

    private String shortName;

    Fuel(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return shortName;
    }
}


