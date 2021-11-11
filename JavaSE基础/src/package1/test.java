package package1;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author Zhang Yang
 * @description
 * @date 2021/7/26 - 15:12
 */
public class test {
    public static void main(String[] args) {
        student s1 = new student("zy", "1971", 90);
        student s2 = new student("zy1", "1972", 98);
        student s3 = new student("zy2", "1973", 78);
//        student[] ss = new student[3];
//        ss[0] = s1;
//        ss[1] = s2;
//        ss[2] = s3;
//        Arrays.sort(ss, Comparator.comparing(student::getAvrscore));
//        TreeSet<student> st=new TreeSet<>();
//        st.add(s1);
//        st.add(s2);
//        st.add(s3);
//        for(student s:st)
//        {
//            s.show();
//        }
//        ArrayQueue<student> sq = new ArrayQueue<>(10);
//        sq.add(s1);
//        sq.add(s2);
//        sq.add(s3);
//        PriorityQueue<student> sp=new PriorityQueue<>();
//        sp.add(s1);
//        sp.add(s3);
//        sp.add(s2);
//        student s4=sp.element();
//        s4.show();
        Map<Integer, student> class1 = new TreeMap<>();
        class1.put(10, s1);
        class1.put(5, s2);
        class1.put(6, s3);
        student s4 = class1.get(5);
        class1.forEach((k, v) -> System.out.println(k + " " + v.getAvrscore()));
        System.out.println("hello world234");
        System.out.println("fixing12");
        System.out.println("hot-fixing from github");
        student s=new student("zy");
        s.show();

    }
}

class student implements Comparable<student> {
    private static int num;
    private String name;
    private String id = "0";
    private int avrscore = 80;
    private teacher t=new teacher("Bob","001","math");

    public student(String name1, String id1, int avrscore1) {
        name = name1;
        id = id1;
        avrscore = avrscore1;
    }

    public student(String name1) {
        name = name1;
    }

    public student(String name1, int avrscore1) {
        name = name1;
        avrscore = avrscore1;
    }

    public void show() {
        System.out.println(name + " " + id + " " + avrscore);
        t.show();
    }

    public student clone1() {
        return this;
    }

    @Override
    public int compareTo(student o) {
        if (avrscore < o.avrscore)
            return -1;
        else if (avrscore > o.avrscore)
            return 1;
        else
            return 0;
    }

    public int getAvrscore() {
        return avrscore;
    }

    public String getName() {
        return name;
    }
}

class studentcompare implements Comparator<student> {

    @Override
    public int compare(student o1, student o2) {
        if (o1.getAvrscore() < o2.getAvrscore())
            return -1;
        else if (o1.getAvrscore() > o2.getAvrscore())
            return 1;
        else return 0;
    }
}

class graduate extends student {  //研究生
    private String grade = "1";  //年级
    private String classid = "7"; //班级
    private String lab = "Devops+";  //所属实验室

    public graduate(String name1, String id1, int avrscore1) {
        super(name1, id1, avrscore1); //调用父类的构造器
    }

    public void show()  //重写
    {
        super.show();  //调用父类的show方法
        System.out.println(grade + " " + classid + " " + lab);
    }

    public graduate clone1() {
        return this;
    }
}

enum Car {
    lamborghini(900), tata(2), audi(50), fiat(15), honda(12);
    private int price;

    Car(int p) {
        price = p;
    }

    int getPrice() {
        return price;
    }
}
