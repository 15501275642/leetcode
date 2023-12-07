package demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Author wangyanji
 * @Date 2023/10/13 14:09
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 2018);
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        String format = fmt.format(calendar.getTime());
        System.out.println(calendar.getTime());
        System.out.println(format);
        calendar.add(Calendar.MONTH, -1);

         format = fmt.format(calendar.getTime());
        System.out.println(calendar.getTime());
        System.out.println(format);


        String yearText = "20230703";
        String[] yearArr = yearText.split(",");
        //-1,-2,-3
        if (Arrays.stream(yearArr).allMatch(s -> Integer.parseInt(s) < 0)) {
            System.out.println();
        }
        //202301，202302
        else if (Arrays.stream(yearArr).allMatch(s -> s.length() == 6)) {
            System.out.println();
        }
        //20230901，20230902
        else if (Arrays.stream(yearArr).allMatch(s -> s.length() == 8)) {
            System.out.println();
        }
        //20230901，-1，-2
        else if((yearArr[0].length() == 6 || yearArr[0].length() == 8)
                && Arrays.stream(Arrays.copyOfRange(yearArr, 1, yearArr.length))
                .allMatch(s -> Integer.parseInt(s) < 0)){
            System.out.println(Arrays.copyOfRange(yearArr, 1, yearArr.length));
        }else {
            System.out.println();
        }


        periodChange("20230703", new ArrayList<>());
        double curr = 150000;
        int week = 1;
        do {
            curr = fuLi(week, 1.02, curr);
            week++;
        } while (week != 100);
    }

    private static double fuLi(int week, double xishu, double curr){
        double v = curr * xishu;
        System.out.println("第"+week+"周结束, 账户金额为" + v);
        return v;
    }


    private static void periodChange(String date, List<String> scenePeriods){
        String year, period;
        int periodIndex = 0;
        if (date.length() == 8 || date.length() == 6) {
            year = date.substring(0, 4);
            periodIndex = Integer.parseInt(date.substring(4, 6));
        } else if (Integer.parseInt(date) < 0) {

        }

        //20231103   202311  -1
        int scenePeriodsSize = scenePeriods.size();
        if (scenePeriodsSize == 1) {
            //年报
        } else if (scenePeriodsSize == 2) {
            //半年报
        } else if (scenePeriodsSize == 4) {
            //季报
        } else if (scenePeriodsSize == 12 || scenePeriodsSize == 13) {
            //月报
            String s = scenePeriods.get(periodIndex);

        } else if (scenePeriodsSize > 300) {
            //日报
        }

    }


}
