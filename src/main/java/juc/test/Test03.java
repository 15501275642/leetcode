package juc.test;


import java.util.Arrays;

public class Test03 {

    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[]{8, 5, 6, 7};
        Test03 test03 = new Test03();
        test03.qs(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void qs(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left, j = right;
        int target = arr[left];

        while (i < j) {
            while (i < j && arr[j] >= target) {
                j--;
            }
            while (i < j && arr[i] <= target) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, left);
        qs(arr, left, i - 1);
        qs(arr, i + 1, right);
    }

    public void swap(int[] arr, int left, int right) {
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }
}
