package juc.producerconsumer.多线程按顺序输出ABC若干次;

public class Test01 {
}

class ThreadPrintABCSequential implements Runnable {

    private static volatile int flag = 1;
    private final Object lock;
    char value;
    public ThreadPrintABCSequential(char value, Object lock) {
        this.lock = lock;
        this.value = value;
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread A = new Thread(new ThreadPrintABCSequential('A', lock));
        Thread B = new Thread(new ThreadPrintABCSequential('B', lock));
        Thread C = new Thread(new ThreadPrintABCSequential('C', lock));
        A.start();
        B.start();
        C.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (value == 'A') {
                synchronized (lock) {
                    while (flag != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    flag = 2;
                    lock.notifyAll();
                }
            } else if (value == 'B') {
                synchronized (lock) {
                    while (flag != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("B");
                    flag = 3;
                    lock.notifyAll();
                }
            } else if (value == 'C') {
                synchronized (lock) {
                    while (flag != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    flag = 1;
                    lock.notifyAll();
                }
            }
        }
    }

}