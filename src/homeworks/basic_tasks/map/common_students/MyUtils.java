package homeworks.basic_tasks.map.common_students;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUtils {
    private final List<Students> list1;
    private final List<Students> list2;

    public MyUtils(List<Students> list1, List<Students> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public Set<Students> getCommonStudents() {
        HashSet<Students> set = new HashSet<>(list1);
        HashSet<Students> result = new HashSet<>(set);
        set.removeAll(list2);
        result.removeAll(set);
        return result;
    }

}
