package demo;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description TODO
 * @Author wangyanji
 * @Date 2023/9/2 16:36
 * @Version 1.0
 */
public class 获取当前日期第一天和最后一天 {


    public static void main(String[] args) {
        Date date = new Date();
        Date monthLastDay = getMonthLastDay(date);
        Date getMonthFirstDay = getMonthFirstDay(date);
        System.out.println();

    }
    /**
     * 获取当前日期所在月份的最后一天
     */
    public static Date getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取当前日期所在月份的第一天
     *
     */
    public static Date getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 0);
        return calendar.getTime();
    }
}

