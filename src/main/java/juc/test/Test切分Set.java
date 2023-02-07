package juc.test;

import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test切分Set {
    /*
     * 切分Set集合
     */
    public static List<List<Long>> groupSet(Set<Long> set) {
        int subSize = 100;
        List<Long> list = new ArrayList<>(set);
        List<List<Long>> listGroup = new ArrayList<>();
        int listSize = list.size();
        //子集合的长度
        int toIndex = subSize;
        for (int i = 0; i < list.size(); i += subSize) {
            if (i + subSize > listSize) {
                toIndex = listSize - i;
            }
            List<Long> newList = list.subList(i, i + toIndex);
            listGroup.add(newList);
        }
        return listGroup;
    }

    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(3L);
        set.add(4L);
        set.add(5L);
        set.add(6L);
        set.add(7L);
        List<List<Long>> lists = groupSet(set);
        System.out.println("set:" + set);
        System.out.println(lists);
    }
}
