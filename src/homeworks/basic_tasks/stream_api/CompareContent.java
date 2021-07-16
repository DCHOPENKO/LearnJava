package homeworks.basic_tasks.stream_api;

import java.util.*;
import java.util.stream.Stream;

public class CompareContent {
    private static final List<String> LIST = Arrays.asList("aa", "bb", "cc", "dd", "aa", "cc");
    private static  Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(1, "aa");
        map.put(2, "cc");
        map.put(3, "dd");
        map.put(4, "aa");
        map.put(5, "cc");
        map.put(6, "aa");
        map.put(7, "bb");

        System.out.println(listMapCompare());
        System.out.println(listMapCompare2());
    }

    public static boolean listMapCompare() {
        Collection<String> values = map.values();
        return LIST.containsAll(values) && values.containsAll(LIST);
    }

    public static boolean listMapCompare2() {
        String streamString = getStreamInString(map.values().stream());
        String streamString2 = getStreamInString(LIST.stream());
        return streamString.equals(streamString2);
    }

    public static String getStreamInString(Stream<String> a) {
        StringBuilder stringBuilder = new StringBuilder();
        a.distinct()
                .sorted(String::compareTo)
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
