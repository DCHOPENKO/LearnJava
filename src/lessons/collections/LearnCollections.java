package lessons.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class LearnCollections {
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();

        aList.add(4);
        aList.add(5);
        aList.add(9);

        List<Integer> lList = new LinkedList<>();

        lList.add(4);
        lList.add(5);
        lList.add(9);
        lList.add(5);

//        aList.trimToSize();

        for (int i = 0; i < lList.size(); i++) {
//            System.out.println(lList.get(i));
        }

        for (Integer value : lList) {
//            lList.remove(value);
        }

        Iterator<Integer> iterator = lList.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();

            if(next == 5) {
//                iterator.remove();
            }
        }

//        lList.removeAll(Arrays.asList(5));

        for (int i = 0; i < lList.size(); i++) {
            if (lList.get(i) == 5) {
//                lList.remove(i);
            }
        }

//        System.out.println(lList);

        Set<Integer> set = new HashSet<>(lList);

        /*set.add(5);
        set.add(1);
        set.add(3);
        set.add(5);*/

//        System.out.println(set);
        Queue<Integer> stack = new PriorityQueue<>();

        stack.add(5);
        stack.add(4);
        stack.add(2);

//        System.out.println(stack.poll());

        CopyOnWriteArrayList<Integer> cowa = new CopyOnWriteArrayList<>();

        cowa.add(5);
        cowa.add(5);
        cowa.add(5);

        for (Integer value : cowa) {
            cowa.remove(value);
        }
    }
}
