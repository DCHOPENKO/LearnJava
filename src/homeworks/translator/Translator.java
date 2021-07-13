package homeworks.translator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class Translator {
    private static final String REGEX = "(([.,!?&])?\\s+)|\\b[.]";
    private static final FileService FILE_SERVICE = new FileService();
    private Set<Dictionary> dictionaries;

    // add new dictionary
    // translate words
    // after input identify language
    // import/export dictionaries from/to files

    public Translator(String stringPath) throws IOException {

        Path path = Paths.get(stringPath);
        dictionaries = FILE_SERVICE.importDictionaries(path);
    }

    public void addDictionary(Dictionary dictionary) {
        dictionaries.add(dictionary);
    }

    public String translateWord(String word, String dictionaryName) {
        Dictionary dictionary = getDictionaryByName(dictionaryName);
        if (dictionary.getVocabulary().isEmpty()) {
            return "No such dictionary";
        }
        return dictionary.getVocabulary().get(word);
    }

    private Dictionary getDictionaryByName(String name) {
        for (Dictionary dictionary : dictionaries) {
            if (dictionary.getName().equals(name)) {
                return dictionary;
            }
        }
        return new Dictionary();
    }

    public String translateWords(String text, String dictionaryName) {
        String[] words = text.split(REGEX);
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(translateWord(word, dictionaryName)).append(" ");
        }
        return result.toString();
    }

    public String getLanguage(String text) {
        String[] words = text.split(REGEX);
        String dictinaryNameFirst = "";
        String dictinaryNameSecond = "";
        for (Dictionary dictionary : dictionaries) {
            if (dictionary.getVocabulary().containsKey(words[0])) {
                dictinaryNameFirst = dictionary.getName();
            }
            if (dictionary.getVocabulary().containsValue(words[0])) {
                dictinaryNameSecond = dictionary.getName();
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

    public void saveDictionaries(String stringPath) throws IOException {
        Path path = Paths.get(stringPath);
        FILE_SERVICE.exportAll(path, dictionaries);
    }

}
