package homeworks.translator;

import java.io.IOException;

public class ForTest {

    public static void main(String[] args) throws IOException {

        Translator translator = new Translator("Dictionaries_For_Translator");

        System.out.println(translator.translateWord("утро", "rus-eng"));
        System.out.println(translator.translateWord("утро", "rus-ukr"));

        Dictionary engRus = new Dictionary("eng-rus");
        engRus.addNewWords("morning", "утро");
        engRus.addNewWords("hello", "привет");
        translator.addDictionary(engRus);

        translator.saveDictionaries("Dictionaries_For_Translator");

        System.out.println(translator.translateWords("morning hello, hello, morning, morning.",
                "eng-rus"));

        System.out.println(translator.translateWords("morning",
                "eng-rus"));

        System.out.println(translator.getLanguage("утро"));
        System.out.println(translator.getLanguage("ранок"));
    }
}


