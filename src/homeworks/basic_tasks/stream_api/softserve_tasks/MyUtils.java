package homeworks.basic_tasks.stream_api.softserve_tasks;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyUtils {

    /* a)   Let the key of Map is project name and value contains list of participants.
    Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted
    stream of all participants without duplication.
    Please ignore null or empty strings, extra spaces and case sensitivity.
    Throw NullPointerException if map is null.
    For example, for a given map
    {"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["Stepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
    you should get
["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]*/

    public Stream<String> getNameList(Map<String, Stream<String>> map) {

        Function<String, String> cleanText = s -> {
            try {
                s = s.replace(" ", "");
                s = s.toLowerCase();
                return s;
            } catch (NullPointerException e) {
                return "";
            }
        };

        Function<String, String> getFormattedText = s -> s.substring(0, 1).toUpperCase() + s.substring(1);

        Collection<Stream<String>> values = map.values();

        return values
                .stream()
                .flatMap(v -> v)
                .map(cleanText)
                .distinct()
                .filter(s -> !s.isEmpty())
                .map(getFormattedText);

    }

    /* b)   Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) method of the MyUtils class to build
 a Map of all phone numbers.
    The key of Map is code of network and value contains sorted list of phones.
    Remove all spaces, brackets and dashes from phone numbers.
    For example, for a given
[["093 987 65 43", "(050)1234567", "12-345"], ["067-21-436-57", "050-2345678", "0939182736", "224-19-28"],
["(093)-11-22-334", "044 435-62-18", "721-73-45"]]
    you should get
    {"050"=["1234567", "2345678"], "067"=["2143657"], "093"=["1122334", "9182736", "9876543"], "044"=["4356218"],
    "loc"=["2241928", "7217345"], "err"=["12345"]}*/

    public Map<String, Stream<String>> getSortedPhoneNumbers(List<Stream<String>> phoneList) {

        Function<String, String> cleanPhoneNumbers = s -> {
            try {
                s = s.replaceAll("[()\\-\\s]", "");
                return s;
            } catch (NullPointerException e) {
                return "";
            }
        };

        Function<String, String> validatePhoneNumbers = s -> {
            if (s.length() != 10 && s.length() != 7) {
                return "err" + s;
            }
            if (s.length() == 7) {
                return "loc" + s;
            }
            return s;
        };

        Function<String, String> fixNumber = s -> s.substring(3);

        return phoneList.stream()
                .flatMap(v -> v)
                .map(cleanPhoneNumbers)
                .distinct()
                .filter(s -> !s.isEmpty())
                .map(validatePhoneNumbers)
                .collect(Collectors.groupingBy(s -> s.substring(0, 3)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().stream().map(fixNumber)));
    }

/*    c) implement a static method getPredicateFromSet(...) in MyUtils class.

    The getPredicateFromSet method should take a Set of predicates working with integers as a parameter and return a
    predicate with the functionality of all predicates in the set involved and connected by logical AND.*/

    public static Predicate<Integer>  getPredicateFromSet (Set<Predicate<Integer>> predicates) {
        Predicate<Integer> result = integer -> true;

        for (Predicate<Integer> predicate: predicates) {
            result = result.and(predicate);
        }
        return result;
    }


}
