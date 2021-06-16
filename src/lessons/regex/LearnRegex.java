package lessons.regex;

import sun.dc.path.PathError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegex {
    public static void main(String[] args) {
        /*String text = "Hallo";
        String pattern = "H.llo";//any symbol*/

        /*String text = "Htllo";
        String pattern = "H[aer]llo";//any symbol from []*/

        /*String text = "Hfllo";
        String pattern = "H[a-t&&[^fd]]llo";//any symbol from a-t, exclude f and d*/
/*
        String text = "Hbllo";
        String pattern = "H[a-eA-E]llo";//any symbol from a to e or from A to E*/

        /*String text = "H8llo";
        String pattern = "H[0-9]llo";//any symbol from 0 to 9*/

/*        String text = "H8llo";
        String pattern = "H\\dllo";//any symbol from 0 to 9*/

        /*String text = "H#llo";
        String pattern = "H\\Wllo";//any spec symbol*/
//        --- Quantors
        /*String text = "H99llo";
        String pattern = "H\\d{2}llo";//{must be}*/
/*
         String text = "Habcdllo";
        String pattern = "H[a-e]{2,5}llo";//{must be}*/

        /*String text = "H99llo";
        String pattern = "H\\d*llo";//any times*/

        /*String text = "H99llo";
        String pattern = "H\\d+llo";//from 1 to any*/

        /*String text = "H99llo";
        String pattern = "H\\d?llo";//{0,1}*/

        /*String text = "AbcCF 43";
        String pattern = "[a-eA-R&&[^Dfd]]{5}\\s?\\d{2}";*/

        String text = "Abgundf";
        String pattern = ".*(run|gun).*";

        System.out.println(Pattern.matches(pattern, text));
    }
}

class LearnMathcer {
    public static void main(String[] args) {
        String text =
                "This is the text which is to be searched " +
                        "for occurrences of the word 'is'.";
        String regex = "is";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.start() + "\t" + matcher.group() + "\t" +matcher.end());
        }

    }
}
