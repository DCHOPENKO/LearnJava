package homeworks.translator;

import java.util.HashMap;
import java.util.Map;

public class Translator {
    private static final String REGEX = "(([.,!?&])?\\s+)|\\b[.]";
    private Map<String, Map<String, String>> dictionaries = new HashMap<>();

    public void addDictionary(Dictionary dictionary) {
        dictionaries.put(dictionary.getName(), dictionary.getMap());
    }

    //  < rus-eng, dictionary >
    //  привет:hello
    //  утро:morning


    // add new dictionary
    // translate words
    // after input identify language
    //

    public String translateWord(String word, String dictionaryName) {
        Map<String, String> dictionary = dictionaries.get(dictionaryName);
        return dictionary.get(word);
    }

    public Map<String, Map<String, String>> getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(Map<String, Map<String, String>> dictionaries) {
        this.dictionaries = dictionaries;
    }

    public String translateWords(String text, String dictionaryName) {
        String[] words = text.split(REGEX);
        StringBuilder result = new StringBuilder();
        Map<String, String> dictionary = dictionaries.get(dictionaryName);
        if (dictionary.isEmpty()) {
            return "No such dictionary";
        }
        for (String word : words) {
            result.append(dictionary.get(word)).append(" ");
        }
        return result.toString();
    }


    public String getLanguage(String text) {
        String[] words = text.split(REGEX);
        String dictinaryNameFirst = "";
        String dictinaryNameSecond = "";
        for (Map.Entry<String, Map<String, String>> entry : dictionaries.entrySet()) {
            if (entry.getValue().containsKey(words[0])) {
                dictinaryNameFirst = entry.getKey();
            }
            if (entry.getValue().containsValue(words[0])) {
                dictinaryNameSecond = entry.getKey();
            }
        }
        if (!dictinaryNameSecond.equals("")) {
            String[] languages = dictinaryNameSecond.split("-");
            return languages[1];
        }
        if (!dictinaryNameFirst.equals("")) {
            String[] languages = dictinaryNameFirst.split("-");
            return languages[0];
        }
        return "Uknown language.";
    }


}
