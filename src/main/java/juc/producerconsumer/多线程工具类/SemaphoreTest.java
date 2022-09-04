package juc.producerconsumer.多线程工具类;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String args[]) {
        Thread A=new Thread(new Service(),"A");
        Thread B=new Thread(new Service(),"B");
        Thread C=new Thread(new Service(),"C");
        A.start();
        B.start();
        C.start();
    }

    private static class Service implements Runnable{

        @Override
        public void run() {
            try{
                semaphore.acquire();
                System.out.println("线程"+Thread.currentThread().getName()+"模拟耗时操作。。。当前时间："+System.currentTimeMillis());
                Thread.sleep(2000L);
                System.out.println("线程"+Thread.currentThread().getName()+"耗时操作完成,当前时间："+System.currentTimeMillis());
                semaphore.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
