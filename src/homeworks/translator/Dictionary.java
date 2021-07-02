package homeworks.translator;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> map;
    private String name;

    //  add new words
    //  create new dictionary

    Dictionary(String name) {
        this.name = name;
        map = new HashMap<>();
    }

    public void addNewWords(String keyWord, String translatedWord) {
        map.put(keyWord, translatedWord);
    }

    public Map<String, String> getMap() {
        return map;
    }

    public String getName() {
        return name;
    }
}

