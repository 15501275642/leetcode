package juc.singleton;

public class Singleton {
    private Singleton() {
    }

    private static class A {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return A.instance;
    }
}

/**
 * 饿汉
 */
class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }

}

/**
 * 懒汉
 */
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}

/**
 * DCL 懒汉
 */
class Singleton3 {
    //Singleton对象属性,加上volatile关键字是为了防止指定重排序,要知道singleton = new Singleton()拆分成cpu指令的话，有足足3个步骤
    private static volatile Singleton3 instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

}

/**
 * 静态内部类
 */
class Singleton4 {
    private Singleton4() {
    }

    private static class Holder {
        private static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Holder.instance;
    }

}

/**
 * 枚举
 */
enum Singleton5 {
    INSTANCE
}