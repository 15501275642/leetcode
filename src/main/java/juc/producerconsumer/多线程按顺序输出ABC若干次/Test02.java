package juc.producerconsumer.多线程按顺序输出ABC若干次;

import javax.sound.sampled.FloatControl;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test02 {
}

class ThreadPrintABCSequential_ReentrantLock implements Runnable {

    private static volatile int flag = 1;
    private final Lock lock;
    private final Condition condition;
    private final char value;

    public ThreadPrintABCSequential_ReentrantLock(Lock lock, Condition condition, char value) {
        this.lock = lock;
        this.condition = condition;
        this.value = value;
    }

    /**
     * 问题描述：
     * 有三个线程顺序打印abc十次，请用线程同步实现。
     */

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ThreadPrintABCSequential_ReentrantLock A = new ThreadPrintABCSequential_ReentrantLock(lock, condition, 'A');
        ThreadPrintABCSequential_ReentrantLock B = new ThreadPrintABCSequential_ReentrantLock(lock, condition, 'B');
        ThreadPrintABCSequential_ReentrantLock C = new ThreadPrintABCSequential_ReentrantLock(lock, condition, 'C');

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(A);
        pool.execute(B);
        pool.execute(C);
        pool.shutdown();
//        new Thread(A).start();
//        new Thread(B).start();
//        new Thread(C).start();

    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                if (value == 'A') {
                    while (flag != 1) {
                        condition.await();
                    }
                    System.out.println('A');
                    flag = 2;
                    condition.signalAll();
                } else if (value == 'B') {
                    while (flag != 2) {
                        condition.await();
                    }
                    System.out.println('B');
                    flag = 3;
                    condition.signalAll();
                } else if (value == 'C') {
                    while (flag != 3) {
                        condition.await();
                    }
                    System.out.println('C');
                    flag = 1;
                    condition.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}