package juc.interrupt;

import juc.util.JucUtil;

/**
 * @description:
 * @author: wangyanji
 * @date: 2022/07/14/11:12
 */
public class InterruptDemo {
    static volatile boolean isStop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                if (isStop) {
                    System.out.println(JucUtil.getThreadName() + "\t isStop被修改为true, 程序停止");
                    break;
                }
                System.out.println("-------hello volatile");
            }
        },"t1").start();
        JucUtil.threadSleepSeconds(0.2);

        new Thread(()-> {
            isStop = true;
        },"t2").start();
    }
}
