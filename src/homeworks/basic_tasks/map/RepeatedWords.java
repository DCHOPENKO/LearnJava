package homeworks.basic_tasks.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedWords {

    public static void main(String[] args) {
        String text = "hello world hello bro g h hello bro";
        List<String> words = Arrays.asList(text.split("\\s"));
        Map<String, Integer> quantityRepeatedWords = new HashMap<>();

     /*   for (String word : words) {
            quantityRepeatedWords.put(word, getRepeatedTimes(word, words));
        }

        for (Map.Entry<String, Integer> entry : quantityRepeatedWords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

        getRepeatedTimes1(words);
    }

    public static Integer getRepeatedTimes(String word, List<String> words) {
        int counter = 0;
        for (String event : words) {
            if (event.equals(word)) {
                counter++;
            }
        }
        return counter;
    }

    public static void getRepeatedTimes1(List<String> words) {

        Map<String, Integer> map = new HashMap<>();

        int counter = 1;
        for (String word : words) {
            if (map.containsKey(word)) {
                counter = map.get(word) + 1;
            }

            map.put(word, counter);
        }

        System.out.println(map);

    }
}
