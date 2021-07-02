package homeworks.basic_tasks.map.common_students;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonStudents {

    public static void main(String[] args) {
        List<Students> list1 = new ArrayList<>();
        list1.add(new Students(1, "Ivan"));
        list1.add(new Students(3, "Vasya"));
        list1.add(new Students(6, "Petya"));
        List<Students> list2 = new ArrayList<>();
        list2.add(new Students(6, "Petya"));
        list2.add(new Students(9, "Igor"));
        list2.add(new Students(1, "Ignat"));
        list2.add(new Students(7, "Ivan"));
        list2.add(new Students(1, "Ivan"));

        MyUtils myUtils = new MyUtils(list1, list2);
        Set<Students> commonStudents = myUtils.getCommonStudents();
        System.out.println(commonStudents);

    }
}
