package juc.test;

import java.util.concurrent.locks.LockSupport;

public class Test04 {

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new LockSupportABC('A'));
        Thread B = new Thread(new LockSupportABC('B'));
        Thread C = new Thread(new LockSupportABC('C'));
        A.start();
        B.start();
        C.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1);
            LockSupport.unpark(A);
            Thread.sleep(1);
            LockSupport.unpark(B);
            Thread.sleep(1);
            LockSupport.unpark(C);
        }
    }
}

class LockSupportABC implements Runnable {

    char value;

    public LockSupportABC(char value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (true) {
            LockSupport.park();
            System.out.println(value);
        }

    }
}

class LockSupportTest {
    public static String name = "A";
    public static Thread threadA;
    public static Thread threadB;
    public static Thread threadC;

    public static void main(String[] args) {
        threadA = new Thread(() -> {
            int num = 0;
            while (true) {
                if (name.equals("A")) {
                    System.out.println("A");
                    name = "B";
                    //给另外一个线程许可证
                    LockSupport.unpark(threadB);
                    if (++num == 10) {
                        break;
                    }
                } else {
                    //禁止当前线程调度资源
                    LockSupport.park();
                }
            }
        });

        threadB = new Thread(() -> {
            int num = 0;
            while (true) {
                if (name.equals("B")) {
                    System.out.println("B");
                    name = "C";
                    //给另外一个线程许可证
                    LockSupport.unpark(threadC);
                    if (++num == 10) {
                        break;
                    }
                } else {
                    //禁止当前线程调度资源
                    LockSupport.park();
                }
            }
        });

        threadC = new Thread(() -> {
            int num = 0;
            while (true) {
                if (name.equals("C")) {
                    System.out.println(name);
                    if (++num == 10) {
                        break;
                    }
                    name = "A";
                    //给另外一个线程许可证
                    LockSupport.unpark(threadA);
                } else {
                    //禁止当前线程调度资源
                    LockSupport.park();
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}


class PRINT_ABC extends Thread {
    private static final int PRINT_NUM = 10;
    private static int flag = 1;
    private final Object lock;
    private char value;

    public PRINT_ABC(Object lock, char value) {
        this.lock = lock;
        this.value = value;
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread A = new PRINT_ABC(lock, 'A');
        Thread B = new PRINT_ABC(lock, 'B');
        Thread C = new PRINT_ABC(lock, 'C');
        A.start();
        B.start();
        C.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < PRINT_NUM; i++) {
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

class TestWithoutVolatile {
    private static volatile int bChanged = 1;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (; ; ) {
                if (bChanged == 0) {
                    System.out.println("!=");
                    System.exit(0);
                }
            }
        }).start();
        Thread.sleep(1);
        new Thread(() -> {
            for (; ; ) {
                bChanged = 0;
            }
        }).start();
    }

}
