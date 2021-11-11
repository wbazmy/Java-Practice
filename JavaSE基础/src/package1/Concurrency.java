package package1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhang Yang
 * @description 并发测试
 * @date 2021/11/1 - 22:28
 */
public class Concurrency {
    public static void main(String[] args) {
//        Runnable r = () -> {
//            System.out.println("doing");
//        };
//        Thread t = new Thread(r);
//        t.start();
        AtomicInteger n=new AtomicInteger(2);
        int i=n.incrementAndGet();
        System.out.println(i);

    }
}

class bank {
    private Condition sufficientFunds;
    private Lock newlcok = new ReentrantLock();
    int[] accounts = new int[10];

    public bank() {
        int i = 0;
        while (i < 10) {
            accounts[i] = 100;
        }
    }

    public void transfer(int from, int to, int amount) {
        newlcok.lock();
        try {
            accounts[from] -= amount;
            accounts[to] += amount;
        } finally {
            newlcok.unlock();
        }
    }

}
