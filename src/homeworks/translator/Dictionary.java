package homeworks.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Dictionary {
    private Map<String, String> vocabulary;
    private String name;

    //  add new words
    //  create new dictionary

    Dictionary(String name) {
        this.name = name;
        vocabulary = new HashMap<>();
    }

    Dictionary() {
    }

    public void addNewWords(String keyWord, String translatedWord) {
        vocabulary.put(keyWord, translatedWord);
    }

    public Map<String, String> getVocabulary() {
        return vocabulary;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary that = (Dictionary) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

