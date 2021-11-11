package package1;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zhang Yang
 * @description 集合测试
 * @date 2021/10/23 - 17:01
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(1, 40);
        for (Integer i : l1) {
            System.out.println(i);
        }
        System.out.println(" ");
        l1.sort(Comparator.reverseOrder());
        for (Integer i : l1) {
            System.out.println(i);
        }
        Set<Integer> s1 = new HashSet<>();
        s1.add(6);
        s1.add(81);
        s1.add(54);
//        for (Integer i : s1) {
//            System.out.println(i);
//        }
        s1 = new TreeSet<>();
        s1.add(511);
        s1.add(45);
        s1.add(412);
//        for (Integer i : s1) {
//            System.out.println(i);
//        }
        TreeSet<student> ts1 = new TreeSet<>(new studentcompare());
        ts1.add(new student("a", 81));
        ts1.add(new student("a", 83));
        ts1.add(new student("a", 65));
//        for(student s:ts1)
//        {
//            s.show();
//        }
//        student s3=ts1.first();
//        s3.show();
        Queue<Integer> q = new PriorityQueue<>(1);
        q.add(5);
        q.offer(1);
        q.add(45);
        int a = q.peek();
        Map<Integer, student> mp1 = new HashMap<>();
        mp1.put(5, new student("a", 81));
        mp1.keySet();
        Arrays.asList();

//        HashSet<String> hs1 = new HashSet<>();
//        hs1.add("a");
//        boolean bl = hs1.add("a");
//        System.out.println(bl);
////        for (String s : hs1) {
////            System.out.println(s);
////        }
    }
}
