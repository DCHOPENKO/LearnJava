package homeworks.basic_tasks.map.common_students;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonStudents {

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1, "Ivan"));
        list1.add(new Student(3, "Vasya"));
        list1.add(new Student(6, "Petya"));
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(6, "Petya"));
        list2.add(new Student(9, "Igor"));
        list2.add(new Student(1, "Ignat"));
        list2.add(new Student(7, "Ivan"));
        list2.add(new Student(1, "Ivan"));

        MyUtils myUtils = new MyUtils(list1, list2);
        Set<Student> commonStudents = myUtils.getCommonStudents();
        System.out.println(commonStudents);

    }
}
