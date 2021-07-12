package homeworks.basic_tasks.stream_api;

import java.util.*;
import java.util.stream.Stream;

public class CompareContent {
    private static List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "aa", "cc");
    private static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(1, "aa");
        map.put(2, "cc");
        map.put(3, "dd");
        map.put(4, "aa");
        map.put(5, "cc");
        map.put(6, "aa");
        map.put(6, "bb");

        System.out.println(listMapCompare());
        System.out.println(listMapCompare2());
        System.out.println(listMapCompare3());
    }

    public static boolean listMapCompare() {
        List<String> valuesList = new ArrayList<>(map.values());
        //       Collections.disjoint(list, valuesList)
        return (list.containsAll(valuesList) && valuesList.containsAll(list));
    }

    public static boolean listMapCompare2() {
        String streamString = getStreamInString(map.values().stream());
        String streamString2 = getStreamInString(list.stream());
        return streamString.equals(streamString2);
    }

    public static String getStreamInString(Stream<String> a) {
        StringBuilder stringBuilder = new StringBuilder();
        a.distinct()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .forEach(h -> stringBuilder.append(h));
        return stringBuilder.toString();
    }

    public static boolean listMapCompare3() {
        List<String> valuesList = new ArrayList<>(map.values());
        return !Collections.disjoint(list, valuesList);
    }

}
