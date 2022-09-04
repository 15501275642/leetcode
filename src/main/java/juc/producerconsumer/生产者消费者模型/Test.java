package juc.producerconsumer.生产者消费者模型;

import java.util.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        //生产者
        new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    if (queue.size() > 0) {
                        try {
                            System.out.println("生产者等待");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = new Random().nextInt();
                    queue.offer(i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("生产者生产:" + i + "并唤醒");
                    queue.notifyAll();
                }
            }
        }).start();

        //消费者
        new Thread(() -> {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        try {
                            System.out.println("消费者等待");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer poll = queue.poll();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费者消费:" + poll + "并唤醒");
                    queue.notifyAll();
                }
            }
        }).start();
    }
}
