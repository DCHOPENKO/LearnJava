package homeworks.basic_tasks.map.common_students;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUtils {
    private final List<Student> list1;
    private final List<Student> list2;

    public MyUtils(List<Student> list1, List<Student> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public Set<Student> getCommonStudents() {
        Set<Student> set = new HashSet<>(list1);
        Set<Student> result = new HashSet<>(list1);
        set.removeAll(list2);
        result.removeAll(set);
        return result;
    }

}
