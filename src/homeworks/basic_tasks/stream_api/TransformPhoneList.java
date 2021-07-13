package homeworks.basic_tasks.stream_api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformPhoneList {

    //  [0678765432 = Ben, 09756753244 = Mark, 0632920452 = Den, 0664538877 = Ben]
    //
    //  [Mark = [09756753244], Ben = [0678765432, 0664538877], Den = [0632920452]]

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("0678765432", "Ben");
        phoneBook.put("09756753244", "Mark");
        phoneBook.put("0632920452", "Den");
        phoneBook.put("0664538877", "Ben");

        Map<String, List<String>> newPhoneBook = new HashMap<>();

        Function<Map.Entry<String, String>, String> function = h -> h.getKey();

        phoneBook.entrySet().stream()//toMap
                .collect(Collectors.groupingBy(v -> v.getValue()))
                .forEach((k, v) -> newPhoneBook.put(k, v.stream()
                        .map(function)
                        .collect(Collectors.toList())));

        Map<String, Map.Entry<String, String>> collect = phoneBook.entrySet().stream()//toMap
                .collect(Collectors.toMap(Map.Entry::getValue, Function.identity()));


        System.out.println(newPhoneBook);
    }

}