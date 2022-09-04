package juc.producerconsumer.多线程工具类;


import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("线程们都准备好了！"));

    public static void testMethod() {
        while (true) {
            try {
                Thread.sleep(new Random().nextInt(10) * 1000);
                System.out.println(Thread.currentThread().getName() + "准备好了！");
                barrier.await();
            } catch (Exception e) {

            }
        }
    }

    public static void main(String args[]) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(CyclicBarrierTest::testMethod, "Thread-" + i);
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
    }
}