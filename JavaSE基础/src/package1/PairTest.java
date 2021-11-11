package package1;

/**
 * @author Zhang Yang
 * @description 测试泛型类
 * @date 2021/10/14 - 11:51
 */
public class PairTest {
    public static void main(String[] args) {
        student s = new student("zy", "12", 92);
        graduate g1 = new graduate("a", "1", 85);
        graduate g2 = new graduate("b", "2", 89);
        graduate g3 = new graduate("c", "3", 95);
        Pair<graduate> p = new Pair<>(g1, g2);
        Pair<? super graduate> p1 = p;
        p1.setFirst(g3);
    }

}

class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;

    }

    public static <U> String Test(U u) {
        String a = u.toString();
        return a;
    }
}