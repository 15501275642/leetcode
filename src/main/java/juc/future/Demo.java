package juc.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * 串行执行
 */
public class Demo {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        // 第一个任务:创建一个包含返回值的CompletableFuture
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        countDownLatch.await();
    }

    public static void main2(String[] args) throws Exception {
        CompletableFuture.supplyAsync(() -> queryCode("中国石油"))
                .thenApplyAsync((code) -> fetchPrice(code))
                .thenAccept((result) -> System.out.println("price: " + result));
        countDownLatch.await();
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        String code = "601857";
        System.out.println("查询证券编码,name:" + name + ",code:" + code);
        return code;
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        Double price = 5 + Math.random() * 20;
        System.out.println("根据证券编码查询价格,code:" + code + ";price:" + price);
        return price;
    }
}
