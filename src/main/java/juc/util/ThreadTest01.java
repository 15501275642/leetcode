package juc.util;


import java.util.ArrayList;

public class ThreadTest01 {
    public static void main(String[] args) {
        // 创建一个仓库对象 共享的  (一个对象一把锁)
        ArrayList<Bread> arrayList = new ArrayList<>();  // 只能存储Bread对象的List集合对象

        // 创建两个线程
        Thread t1 = new Thread(new Producer(arrayList));
        Thread t2 = new Thread(new Consumer(arrayList));

        // 设置name
        t1.setName("生产者线程");
        t2.setName("消费者线程");

        // 开启线程
        t1.start();
        t2.start();
        // 因为两个线程共享一个仓库对象, 有synchronized关键字修饰,那么t1、t2线程就需要进行抢锁,先抢到了先执行,
        // 假设t1先抢到对象锁,那么t1线程run先跑程序,此时t2等着对象锁,等t1把对象锁释放后t2拿到锁开始执行

    }
}

// 生产线程
class Producer implements Runnable {
    // 拿到仓库对象
    ArrayList<Bread> list;

    // 通过构造方法拿到仓库对象
    public Producer(ArrayList<Bread> list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直生产(死循环)
        while (true) {
            // synchronized : 因为两个线程共享该仓库对象,让两个线程抢锁的目的是保证线程安全
            synchronized (list) {    // 当前对象锁：当前对象是list仓库对象
                if (list.size() > 0) {    // 大于0,说明仓库中已经有一个元素了 仓库已经满了等着消费进程进行消费
                    try {
                        list.wait();    // 仓库满了 让当前线程进入等待状态,并且释放掉list集合对象的锁, 因为一个对象就一把锁
                    } catch (InterruptedException e) {  // 假设生产线程synchronized已经抢到了这把锁, 这里要把锁释放掉 消费线程才能拿到锁跑程序
                        e.printStackTrace();
                    }
                }
                // 程序能执行到这里 说明仓库为空
                // 向仓库中添加元素
                Bread bread = new Bread("面包~");
                list.add(bread);
                System.out.println(Thread.currentThread().getName() + "生产了:" + bread.getName());

                // 生产完毕后 唤醒消费者进行消费
                list.notify();

                // 代码全部执行完毕后,此生产者会释放掉对象锁 然后重新开始抢对象锁, 有可能释放后对象锁被消费线程抢到了
                // 也有可能释放掉后生产者又抢到了对象锁, 但即使生产者又抢到了对象锁 仓库已经满了 生产者还是只能释放对象锁
                // 进入等待状态   (执行效率低)
            }
        }

    }
}

// 消费线程
class Consumer implements Runnable {
    // 拿到仓库对象
    ArrayList<Bread> list;

    // 通过构造方法拿到仓库对象
    public Consumer(ArrayList<Bread> list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直消费
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {   // 仓库集合等于0 说明仓库为空 进入等待状态,同生产线程一样把对象锁释放掉,让生产者生产
                    try {
                        list.wait();    // 进入等待状态,释放掉对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 代码执行到这里 说明仓库满了 需要进行消费
                Bread bread = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "消费了:" + bread.getName());

                // 同理 消费后 唤醒生产线程 开始生产面包
                list.notify();
            }
        }

    }
}

class Bread {
    private String name;

    public Bread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return name;
    }
}
