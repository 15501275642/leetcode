package juc.producerconsumer.多线程工具类;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static CountDownLatch down = new CountDownLatch(1);


    public static void main(String args[]) throws InterruptedException {
        new MyThread().start();
        try {
            Thread.sleep(2000);
            System.out.println("线程" + Thread.currentThread().getName() + "要叫醒子线程了！");
            down.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("等待" + Thread.currentThread().getName() + "准备就绪");
                down.await();
                System.out.println(Thread.currentThread().getName() + "开始运行！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
