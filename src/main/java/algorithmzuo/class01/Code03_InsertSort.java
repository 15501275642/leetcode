package algorithmzuo.class01;

import java.util.Arrays;

/**
 * @Description 插入排序 斗地主抓拍
 * @Author wangyanji
 * @Date 2023/2/1 15:47
 * @Version 1.0
 */
public class Code03_InsertSort {

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
        //1. 0~0范围有序
        //2. 0~1范围有序
        //3. 0~2范围有序
        //4. ...
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                //交换
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
