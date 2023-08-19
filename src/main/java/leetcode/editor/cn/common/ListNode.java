package leetcode.editor.cn.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @description:
 * @author: wangyanji
 * @date: 2022/07/25/16:39
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main1(String[] args) {

        String str = "¥1,000.00";
        String s1 = str.replace("¥", "").replace(",", "");
        BigDecimal bigDecimal = new BigDecimal(s1);
        System.out.println();
        //求单价保留6位小数
        BigDecimal divide = new BigDecimal("1000")
                .divide(new BigDecimal("1"), 6, RoundingMode.HALF_UP);
        String s = divide.toString();
        int b = 4;
        {
            int a = 0;
            System.out.println(a);
        }

    }

    /**
     * 判断两个日期是否为同一年份
     */
    private static boolean isSameDateYear(Date date1, Date date2){
        if (Objects.isNull(date1) || Objects.isNull(date2)){
            return false;
        }
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return cal1.get(Calendar.YEAR) == cal2
                    .get(Calendar.YEAR);
    }

    public static void main(String[] args) {
        isSameDateYear(new Date(), new Date());
    }
}
