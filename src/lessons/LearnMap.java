package lessons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class LearnMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("One", 1);
        map.put("One", 2);

//        System.out.println(map);

        Map<ForMap, String> map1 = new HashMap<>();

        ForMap john = new ForMap("John", 12);
        ForMap jack = new ForMap("John", 12);

//        if (e.hash == hash && (e.key == key || key.equals(e.key)))
        /*
        * 1) equals not overrided, hashcode ovveride - 2
        * 2) equals overrided, hashcode notovveride - 2
        * 3) equals overrided, hashcode ovveride - 1
        * 4) equals overrided, hashcode return const value - 1
        * */

        map1.put(null, "One");
        map1.put(null, "Two");

        System.out.println(map1);

    }
}

class ForMap {
    private String name;
    private int age;

    public ForMap(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForMap forMap = (ForMap) o;
        return age == forMap.age && Objects.equals(name, forMap.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "ForMap{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
