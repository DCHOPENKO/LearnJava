package homeworks.basic_tasks.multi_threading.factory;

public enum ProductionPhase {

    SURVEY("Surveying"),
    DESIGN("Designing"),
    DEVELOP("Developing"),
    TEST("Testing"),
    FINISHED("Product Ready");

    private final String shortDescription;

    ProductionPhase(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
