package homeworks.translator;

public enum Language {

    ENGLISH("eng", "english"),
    RUSSIAN("rus", "russian"),
    UKRAINIAN("ukr", "ukrainian");

    private String shortName;
    private String name;

    Language(String shortNam, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }


}
