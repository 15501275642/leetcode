package algorithmzuo.util;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author wangyanji
 * @Date 2023/2/23 11:04
 * @Version 1.0
 */
public class ArrayUtil {
    public static int[] generateRandomArray(int maxSize, int maxValue){
        //Math.random() -> [0, 1)所有的小数,等概率返回一个
        //Math.random() * N -> [0, N)所有的小数,等概率返回一个
        //(int)Math.random() * N -> [0, N-1)所有的整数,等概率返回一个

        //长度随机
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - (int)(maxValue * Math.random()));
        }
        return arr;
     }


    public static void main(String[] args) {
        int[] ints = generateRandomArray(6, 100);
        System.out.println(Arrays.toString(ints));

    }
}
