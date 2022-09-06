package juc.future;


import java.util.concurrent.CompletableFuture;

public class Demo3 {

    public static void main(String[] args) {

        //任务1：洗水壶 -> 烧开水
        CompletableFuture<String> f11 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T1:洗水壶...开始");
            sleep(2000);
            return "T1:洗水壶...完成";
        });
        CompletableFuture<String> f12 = f11.thenApply((f11Result) -> {
            System.out.println(f11Result);
            System.out.println("T1:烧开水...开始");
            sleep(3000);
            return "T1:烧开水...完成";
        });

        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<Void> f21 = CompletableFuture.runAsync(() -> {
            System.out.println("==============T2:洗茶壶...开始");
            sleep(2000);
            System.out.println("==============T2:洗茶壶...完成");
        });
        CompletableFuture<Void> f22 = f21.thenRun(() -> {
            System.out.println("==============T2:洗茶杯...开始");
            sleep(2000);
            System.out.println("==============T2:洗茶杯...完成");
        });
        CompletableFuture<String> f23 = f22.thenApply(result -> {
            System.out.println("==============T2:拿茶叶...开始");
            sleep(2000);
            System.out.println("==============T2:拿茶叶...完成");
            return "龙井";
        });
        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture<String> f3 = f12.thenCombine(f23, (f1Result, f2Result) -> {
            System.out.println(f1Result);
            System.out.println("************T2:拿到茶叶:result" + f2Result);
            System.out.println("************T3:泡茶...,什么茶:" + f2Result);
            return "上茶:" + f2Result;
        });
        //等待任务3执行结果
        System.out.println(f3.join());
    }

    static void sleep(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
