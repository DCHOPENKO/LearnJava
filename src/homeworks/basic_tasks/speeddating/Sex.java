package homeworks.basic_tasks.speeddating;

public enum Sex {
    MALE("Male"),
    FEMALE("Female"),
    NOT_SET("Not set");

    private String shortName;

    Sex(String shortName) {
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
