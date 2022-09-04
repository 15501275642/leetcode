package juc.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Thread producer = new Thread(new Producer(list));
        Thread consumer = new Thread(new Consumer(list));
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable{
    final List<Integer> list;
    public Producer(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = new Random().nextInt();
                list.add(i);
                System.out.println("生产者生产了" + i);
                list.notify();
            }
        }
    }
}
class Consumer implements Runnable{
    final List<Integer> list;
    public Consumer(List<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产者消费了" + list.get(0));
                list.remove(0);
                list.notify();
            }
        }
    }
}