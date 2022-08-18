package juc.util;

/**
 * @description: juc 工具类
 * @author: wangyanji
 * @date: 2022/07/14/11:16
 */
public class JucUtil {

    public static void threadSleepSeconds(double seconds) {
        try {
            Thread.sleep((int)seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getThreadName () {
        return Thread.currentThread().getName();
    }
}
