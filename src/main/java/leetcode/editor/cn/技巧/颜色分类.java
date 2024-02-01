//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1718 👎 0

package leetcode.editor.cn.技巧;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 颜色分类
 *
 * @author wangyanji
 * @date 2024-01-03 09:57:14
 */
public class 颜色分类 {
    public static void main(String[] args) {
        Date now = new Date();
        Date startDate = ConvertToDateTime("2020-01-01");;
        Date endDate = ConvertToDateTime("2023-05-06");;

        getCurrentMonthMinTime(now);
        getCurrentMonthMaxTime(now);


        boolean isBetween = now.compareTo(startDate) > 0 && now.compareTo(endDate) < 0;


        Solution solution = new Solution();
        int[] nums = {2, 3, 3, 1, 3, 2};
        solution.sortColorsOne(nums);
    }
    private static Date getCurrentMonthMinTime(Date now) {
        // 创建 Calendar 对象并设置为指定日期
        Calendar calendar = Calendar.getInstance();
        int year = 2021;   // 年份
        int month = 9;     // 月份（注意：月份从0开始计数）
        int dayOfMonth = 5;// 日期

        calendar.set(year, month - 1, dayOfMonth);

        // 将日期调整到本月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 0时0分0秒
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // 输出结果
        System.out.println("当前日期所在月份的最小时间：" + calendar.getTime());
        return calendar.getTime();

    }

    private static Date getCurrentMonthMaxTime(Date now) {
        // 创建 Calendar 对象并设置为指定日期
        Calendar calendar = Calendar.getInstance();
        int year = 2021;   // 年份
        int month = 10;     // 月份（注意：月份从0开始计数）
        int dayOfMonth = 30;   // 天数

        calendar.set(year, month - 1, dayOfMonth);

        // 将日期调整到下个月第一天
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // 再次调整日期至前一天
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        // 输出结果
        System.out.println("当月最后一天的日期：" + calendar.getTime());
        return calendar.getTime();

    }
    public static Date ConvertToDateTime(String stime) {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(dateformatter.parse(stime));
        } catch (Exception arg3) {
            return null;
        }

        return cal.getTime();
    }

    /**
     * 单指针
     */
    static class Solution {
        public void sortColorsOne(int[] nums) {
            int n = nums.length;
            int ptr = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    //ptr和i位置进行交换
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
            for (int i = ptr; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
        }
    }
}