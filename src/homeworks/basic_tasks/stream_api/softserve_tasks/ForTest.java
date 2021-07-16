package homeworks.basic_tasks.stream_api.softserve_tasks;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForTest {

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();

        // a)

        Map<String, Stream<String>> map = new HashMap<>();
        map.put("Desktop", Stream.of(" iVan", "PeTro ", "    ", " Ira "));
        map.put("Web", Stream.of("Stepan", "ira ", " Andriy ", null, "an na"));
        map.put("Spring", Stream.of("Ivan", "Anna"));

        Stream<String> nameList = myUtils.getNameList(map);
        nameList.forEach(System.out::println);

        // b)
        List<Stream<String>> phoneList = new ArrayList<>();
        phoneList.add(Stream.of("093 987 65 43", "(050)1234567", "12-345"));
        phoneList.add(Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"));
        phoneList.add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45"));

        Map<String, Stream<String>> sortedPhoneNumbers = myUtils.getSortedPhoneNumbers(phoneList);
        sortedPhoneNumbers.forEach((key, value) -> System.out.println(key + "=" + value.collect(Collectors.toList())));

        // c)

        Set<Predicate<Integer>> set = new HashSet<>();
        set.add(integer -> integer > 10);
        set.add(integer -> integer < 20);

        Predicate<Integer> predicate = MyUtils.getPredicateFromSet(set);

        Stream<Integer> stream =  Stream.of(5, 4, 3, 11, 12, 15, 25, 26);

        stream.filter(predicate).forEach(System.out::println);

        System.out.println(predicate.toString());

    }


}








