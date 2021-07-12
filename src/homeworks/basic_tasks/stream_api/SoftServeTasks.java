package homeworks.basic_tasks.stream_api;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoftServeTasks {

/* a)   Let the key of Map is project name and value contains list of participants.
    Create a Stream<String> nameList(Map<String, Stream<String>> map) method of the MyUtils class to build sorted
    stream of all participants without duplication.
    Please ignore null or empty strings, extra spaces and case sensitivity.
    Throw NullPointerException if map is null.
    For example, for a given map
    {"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ", " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
    you should get
["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]*/


/* b)   Create a Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) method of the MyUtils class to build
 a Map of all phone numbers.
    The key of Map is code of network and value contains sorted list of phones.
    Remove all spaces, brakets and dashes from phone numbers.
    For example, for a given
[["093 987 65 43", "(050)1234567", "12-345"], ["067-21-436-57", "050-2345678", "0939182736", "224-19-28"],
["(093)-11-22-334", "044 435-62-18", "721-73-45"]]
    you should get
    {"050"=["1234567", "2345678"], "067"=["2143657"], "093"=["1122334", "9182736", "9876543"], "044"=["4356218"],
    "loc"=["2241928", "7217345"], "err"=["12345"]}*/

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();

        // a)

        Map<String, Stream<String>> map = new HashMap<>();
        map.put("Desktop", Stream.of(" iVan", "PeTro ", "    ", " Ira "));
        map.put("Web", Stream.of("STepan", "ira ", " Andriy ", null, "an na"));
        map.put("Spring", Stream.of("Ivan", "Anna"));

        Stream<String> nameList = myUtils.getNameList(map);
        nameList.forEach(s -> System.out.println(s));

        System.out.println("");

        // b)
        List<Stream<String>> phoneList = new ArrayList<>();
        phoneList.add(Stream.of("093 987 65 43", "(050)1234567", "12-345"));
        phoneList.add(Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"));
        phoneList.add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45"));

        Map<String, Stream<String>> sortedPhoneNumbers = myUtils.getSortedPhoneNumbers(phoneList);

        sortedPhoneNumbers.forEach((key, value) -> System.out.println(key + "=" + value.collect(Collectors.toList())));
    }
}

class MyUtils {

    public Stream<String> getNameList(Map<String, Stream<String>> map) {
        List<String> list = new LinkedList<>();

        map.values().forEach(v -> list.addAll(v.collect(Collectors.toList())));

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

        Stream<String> result = list.stream()
                .map(cleanText)
                .distinct()
                .filter(s -> !s.isEmpty())
                .map(getFormattedText);

        return result;
    }

    public Map<String, Stream<String>> getSortedPhoneNumbers(List<Stream<String>> phoneList) {
        List<String> phoneNumbers = new ArrayList<>();

        phoneList.forEach(v -> phoneNumbers.addAll(v.collect(Collectors.toList())));

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

        Map<String, Stream<String>> result = phoneNumbers.stream()
                .map(cleanPhoneNumbers)
                .distinct()
                .filter(s -> !s.isEmpty())
                .map(validatePhoneNumbers)
                .collect(Collectors.groupingBy(s -> s.substring(0, 3)))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().stream().map(fixNumber)));
        return result;
    }
}








