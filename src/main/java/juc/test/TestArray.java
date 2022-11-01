package juc.test;

import java.util.*;

public class TestArray {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("15501275642", "18801275642");

        Set<String> resSet = new HashSet<>(strings);

        System.out.println(resSet);


        Object[] objects = strings.toArray();
        Map<String, Object> map = new HashMap<>();
        map.put("p", objects);

        Object p = map.get("p");
        System.out.println();




    }


}
