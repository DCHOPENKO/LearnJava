package homeworks.translator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        DataExport data = new DataExport();
        Translator translator = new Translator();
        Path rootPath = DataExport.getPath("Dictionaries_For_Translator");

        translator.setDictionaries(data.importAll(rootPath));

        System.out.println(translator.translateWord("утро", "rus-eng"));
        System.out.println(translator.translateWord("утро", "rus-ukr"));

        Dictionary eng_rus = new Dictionary("eng-rus");
        eng_rus.addNewWords("morning", "утро");
        eng_rus.addNewWords("hello", "привет");
        translator.addDictionary(eng_rus);
        data.exportAll(rootPath, translator.getDictionaries());

        System.out.println(translator.translateWords("morning hello, hello, morning, morning.",
                "eng-rus"));

        System.out.println(translator.translateWords("morning",
                "eng-rus"));

        System.out.println(translator.getLanguage("утро"));
        System.out.println(translator.getLanguage("ранок"));
    }
}


