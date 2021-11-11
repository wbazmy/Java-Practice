package package1;

import javax.sound.midi.Soundbank;

/**
 * @author Zhang Yang
 * @description wait方法测试
 * @date 2021/11/8 - 17:55
 */
public class waittest {
    public static void main(String[] args) throws InterruptedException {
        thread1 t1=new thread1();
        thread2 t2=new thread2(t1);
        System.out.println("main running");
        synchronized (t1) {
            t1.start();
            t2.start();
            t1.join();
        }

        System.out.println("main ending");

    }
}

class thread1 extends Thread {
    public void run() {
        System.out.println("thread1 is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread1 ending");
    }
}

class thread2 extends Thread {
    thread1 t;
    public thread2(thread1 t1){
        t=t1;
    }
    public void run() {
        synchronized (t){
            System.out.println("thread2 is running");
            System.out.println("thread2 ending");
        }
    }
}
