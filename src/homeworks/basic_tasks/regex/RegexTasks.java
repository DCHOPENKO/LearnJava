package homeworks.basic_tasks.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTasks {

    public static void main(String[] args) {
        String pattern;
        String textBlock;

        // a) Любое количество букв, а потом две цифры и наоборот.
        textBlock = "SADgjkvscmJJdsmkSMCkmlk12";
        pattern = "\\w*\\d{2}";
        System.out.println("Some letters after 2 digits is " + Pattern.matches(pattern, textBlock));

        textBlock = "12FsdfvdsvSDF";
        pattern = "\\d{2}\\w*";
        System.out.println("2 digits after some letters is " + Pattern.matches(pattern, textBlock));

        // b) 2-4 цифры, а потом 2-4 буквы и наоборот.
        textBlock = "342vjgb";
        pattern = "\\d{2,4}.{2,4}";
        System.out.println("2-4 digits after 2-4 letters is " + Pattern.matches(pattern, textBlock));

        textBlock = "gb123";
        pattern = "[A-Za-z]{2,4}\\d{2,4}";
        System.out.println("2 letters after 2-4 digits is " + Pattern.matches(pattern, textBlock));

        // c) Пользователь вводит имя и фамилию.
        //Буквы могут быть в разных регистрах. Проверить, чтобы первые буквы были в верхнем регистре,
        // а остальные буквы - в нижнем.
        textBlock = "Vasya Pupkin";
        pattern = "\\b[A-Z][a-z]+";
        System.out.println("Name Surname in format \"Xxxxx Yyyyy\" is " + Pattern.matches(pattern, textBlock));


        // d) Пользователь вводит телефон в формате (ххх)ххх-хх-хх.  ....  (095), (097), (073), (067), (099), (063) ...
        String phoneNumber = "(095)333-43-52";
        String start = "\\((095|(097)|(073)|(067)|(099)|(063))\\)";
        pattern = start + "\\d{3}-\\d{2}-\\d{2}";
        System.out.println("Phone number in format (xxx)xxx-xx-xx is " + Pattern.matches(pattern, phoneNumber));
        Pattern patternPhoneCode = Pattern.compile(start);
        Matcher matcher = patternPhoneCode.matcher(phoneNumber);
        String operatorCode = "";
        String code = "";
        while (matcher.find()) {
            operatorCode = matcher.group();
        }
        if (operatorCode.equals("(095)") || operatorCode.equals("(099)")) {
            code =  "MTS";
        }
        if (operatorCode.equals("(097)") || operatorCode.equals("(067)")) {
            System.out.println("User have Kievstar number, Operator code is " + operatorCode);
        }
        if (operatorCode.equals("(073)") || operatorCode.equals("(063)")) {
            System.out.println("User have Life number, Operator code is " + operatorCode);
        }

        System.out.println("User have " + code + " number, Operator code is " + operatorCode);


        // e)  The input data should be uploaded from the 'part3.txt' file ......
        System.out.println("Input what kind of data need to filter from text " +
                "\nchar - print all characters \nstring - print all text blocks \nint - print all int values" +
                "\ndouble = print all double values \nstop - exit");
        Scanner reader = new Scanner(System.in);
        Parser parser = new Parser("a g bcd 43.43 432 и л фвыа 89.98  .87 f");
        String operator = "";
        while (!operator.equals("stop")) {
            operator = reader.nextLine();
            switch (operator) {
                case "char":
                    parser.printElements(parser.getCharMatcher());
                    break;
                case "string":
                    parser.printElements(parser.getStringMatcher());
                    break;
                case "int":
                    parser.printElements(parser.getIntMatcher());
                    break;
                case "double":
                    parser.printElements(parser.getDoubleMatcher());
                    break;
                case "stop":
                    break;
                default:
                    System.out.println("Incorrect input, try one more time");
            }
        }

        //f) В строке содержутся слова и числа. Необходмо выделить числа и посчитать их сумму.
        textBlock = "50.5 Vasya fa fds ds 5 ff 5 5 5   5 dsd";
        Parser parserDigits = new Parser(textBlock);
        Double sumDigitsValues = parserDigits.sumDigitsElements(parserDigits.getDoubleMatcher())
                + parserDigits.sumDigitsElements(parserDigits.getIntMatcher());
        System.out.println(sumDigitsValues);
    }
}
