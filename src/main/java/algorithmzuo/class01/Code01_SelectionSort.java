package algorithmzuo.class01;

import java.util.Arrays;

/**
 * @Description 选择排序 每次循环把本次找到的最小元素从前到后依次放在数组中
 * @Author wangyanji
 * @Date 2023/2/1 15:47
 * @Version 1.0
 */
public class Code01_SelectionSort {

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
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
