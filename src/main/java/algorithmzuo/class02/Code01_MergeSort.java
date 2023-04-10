package algorithmzuo.class02;

import java.util.Arrays;

/**
 * @Description 归并排序
 * @Author wangyanji
 * @Date 2023/2/1 15:47
 * @Version 1.0
 */
public class Code01_MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 8, 3, 54, 6, 7};
        selectionSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        //校验数据的大小是否大于等2
        if (arr == null || arr.length < 2) {
            return;
        }
        //从(i+1)-(length)位置找最小元素,放到i位置上
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //找最小元素
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            //交换
            //swap(arr, i, minIndex);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r) {
            //help[i++] =
        }

    }
}
