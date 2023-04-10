package algorithmzuo.class01;

/**
 * @Description
 * @Author wangyanji
 * @Date 2023/2/1 17:59
 * @Version 1.0
 */
public class Code08_GetMax {
    public static void main(String[] args) {
        int[] arr = {7, 3, 89, 6, 3, 2, 2, 45};
        System.out.println(getMax(arr));

    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        for (int i = l; i < r; i++) {
            System.out.println(arr[i]);
        }
        //中点
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

}
