package homeworks.basic_tasks.patterns.builder;

enum Selector {
    AND(" AND "), OR(" OR ");
    private final String shortName;

    Selector(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
