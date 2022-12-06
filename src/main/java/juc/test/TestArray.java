package juc.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestArray {
    public static void main(String[] args) {
        Long start = Long.valueOf(1);
        Long limit = Long.valueOf(3);
        Set<Long> filterUserIdSetx = new HashSet<>();
        filterUserIdSetx.add(Long.valueOf(1));
        filterUserIdSetx.add(Long.valueOf(2));
        filterUserIdSetx.add(Long.valueOf(3));
        filterUserIdSetx.add(Long.valueOf(4));
        filterUserIdSetx.add(Long.valueOf(5));
         //Comparator.comparing((Function<Object, Object>) o -> o);

        ((Set)filterUserIdSetx).stream().sorted(


        ).skip((long)start).limit((long)limit).collect(Collectors.toList());
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
