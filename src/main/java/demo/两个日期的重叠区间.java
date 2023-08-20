package demo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wangyanji
 * @Date 2023/2/12 10:53
 * @Version 1.0
 */

public class 两个日期的重叠区间 {
    public static void main(String[] args) {
        boolean a = true;
        Object b = a;
        String s = b.toString();
        System.out.println(s);
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(null);
            add(1);
        }};

        List<Integer> collect = list.stream().filter(Objects::nonNull).collect(Collectors.toList());

        System.out.println(list);

        LocalDate i1Start = LocalDate.of(2023, 2, 2);
        LocalDate i1End = LocalDate.of(2023, 2, 11);
        LocalDate i2Start = LocalDate.of(2023, 1, 25);
        LocalDate i2End = LocalDate.of(2023, 2, 6);

        //求出标准天数的的具体日期
        List<LocalDate> allDatesInTheDateRange1 = getAllDatesInTheDateRange(i1Start, i1End);


        //求出两个日期区间的交集区间
        List<LocalDate> localDates = overLappingDay(i1Start, i1End, i2Start, i2End);
        //求出交集区间的具体日期
        List<LocalDate> allDatesInTheDateRange = getAllDatesInTheDateRange(localDates.get(0), localDates.get(1));

        System.out.println();


    }

    public static List<LocalDate> getAllDatesInTheDateRange(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> localDateList = new ArrayList<>();
        // 开始时间必须小于结束时间
        if (startDate.isAfter(endDate)) {
            return new ArrayList<>();
        }
        while (startDate.isBefore(endDate)) {
            localDateList.add(startDate);
            startDate = startDate.plusDays(1);
        }
        localDateList.add(endDate);
        return localDateList;
    }

    public static List<LocalDate> overLappingDay(LocalDate i1Start, LocalDate i1End, LocalDate i2Start, LocalDate i2End) {
        List<LocalDate> list = new ArrayList<>();
        if (i1End.isBefore(i1Start) || i2End.isBefore(i2Start)) {
            return list;
        } else {
            if (i1End.isBefore(i2Start) || i2End.isBefore(i1Start)) {
                // no overlap
                return new ArrayList<>();
            } else {
                LocalDate laterStart = Collections.max(Arrays.asList(i1Start, i2Start));
                LocalDate earlierEnd = Collections.min(Arrays.asList(i1End, i2End));
                return Arrays.asList(laterStart, earlierEnd);
            }
        }
    }
}
