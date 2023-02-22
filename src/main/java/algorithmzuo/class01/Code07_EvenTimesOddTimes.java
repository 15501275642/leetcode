package algorithmzuo.class01;

/**
 * @Description 异或运算 相同为0 不同为1
 * @Author wangyanji
 * @Date 2023/2/1 17:59
 * @Version 1.0
 */
public class Code07_EvenTimesOddTimes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 5, 5, 5};
        //printOddTimesNum1(arr);
        printOddTimesNum2(arr);

    }

    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        //eor = a ^ b
        //eor != 0
        //eor必然有一个位置上是1
        //提取出最右的1
        int rightOne = eor & (~eor + 1);
        //eor'
        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
