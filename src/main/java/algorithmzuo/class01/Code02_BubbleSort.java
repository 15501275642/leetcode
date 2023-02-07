package algorithmzuo.class01;

import java.util.Arrays;

/**
 * @Description 冒泡排序 每次循环把本次找到的最大元素从后到前依次放在数组中
 * @Author wangyanji
 * @Date 2023/2/1 15:47
 * @Version 1.0
 */
public class Code02_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 8, 3, 54, 6, 7};
        bubbleSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        //校验数据的大小是否大于等2
        if (arr == null || arr.length < 2) {
            return;
        }
        //循环的轮数
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //两两比较
                if (arr[j] > arr[j + 1]) {
                    //交换
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
