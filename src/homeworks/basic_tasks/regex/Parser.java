package homeworks.basic_tasks.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String REGEX_CHAR = "\\b[A-Za-zА-яа-я]{1}\\b";
    private static final String REGEX_INT = "\\b(^|[^\\.]|\\s+)\\d+(?!\\.)\\b";
    private static final String REGEX_DOUBLE = "(0|[1-9]\\d*)[\\.,]\\d+";
    private static final String REGEX_STRING = "[A-Za-zА-яа-я]{2,}";
    private String textBlock;

    Parser(String textBlock) {
        this.textBlock = textBlock;
    }

    private Matcher initMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(textBlock);
    }

    public Matcher getCharMatcher() {
        return initMatcher(REGEX_CHAR);
    }

    public Matcher getIntMatcher() {
        return initMatcher(REGEX_INT);
    }

    public Matcher getDoubleMatcher() {
        return initMatcher(REGEX_DOUBLE);
    }

    public Matcher getStringMatcher() {
        return initMatcher(REGEX_STRING);
    }

    public void printElements(Matcher matcher) {
        while (matcher.find()) {
            System.out.print(matcher.group() + "\t");
        }
        System.out.println("");
    }

    public double sumDigitsElements(Matcher matcher) {
        double result = 0d;
        while (matcher.find()) {
            result += Double.parseDouble(matcher.group());
        }
        return result;
    }
}
