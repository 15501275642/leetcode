package demo.googletable;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * @Description TODO
 * @Author wangyanji
 * @Date 2023/7/26 17:17
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        String message = String.join("Java", "is", "cool");

        System.out.println();


        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");

        System.out.println("sites 1: " + sites);

        // 创建另一个动态数组
        ArrayList<String> sites2 = new ArrayList<>();

        // 往动态数组中添加元素
        sites2.add("Wiki");
        sites2.add("Runoob");
        sites2.add("Google");
        System.out.println("sites 2: " + sites2);

        // 保留元素
        sites.retainAll(sites2);
        System.out.println("保留的元素: " + sites);



        Table<String, String, Integer> tables = HashBasedTable.create();
        //测试数据
        tables.put("a", "javase", 80);
        tables.put("b", "javase", 90);
        tables.put("a", "oracle", 100);
        tables.put("c", "oracle", 95);
        //所有的行数据
        Set<Cell<String, String, Integer>> cells = tables.cellSet();
        for (Cell<String, String, Integer> temp : cells) {
            System.out.println(temp.getRowKey() + ":" + temp.getColumnKey() + ":" + temp.getValue());
        }
        /**
         * b:javase:90
         c:oracle:95
         a:oracle:100
         a:javase:80
         */
        System.out.println("==========学生查看成绩==============");
        System.out.print("学生\t");
        //所有的课程
        Set<String> cours = tables.columnKeySet();
        for (String t : cours) {
            System.out.print(t + "\t");
        }
        System.out.println();
        //所有的学生
        Set<String> stus = tables.rowKeySet();
        for (String stu : stus) {
            System.out.print(stu + "\t");
            Map<String, Integer> scores = tables.row(stu);
            for (String c : cours) {
                System.out.print(scores.get(c) + "\t");
            }
            System.out.println();
        }
        /**
         * 学生	javase	oracle
         b	90	null
         c	null	95
         a	80	100
         */
        System.out.println("==========课程查看成绩==============");
        System.out.print("课程\t");
        //所有的学生
        Set<String> stuSet = tables.rowKeySet();
        for (String t : stuSet) {
            System.out.print(t + "\t");
        }
        System.out.println();
        //所有的课程
        Set<String> courSet = tables.columnKeySet();
        for (String c : courSet) {
            System.out.print(c + "\t");
            Map<String, Integer> scores = tables.column(c);
            for (String s : stuSet) {
                System.out.print(scores.get(s) + "\t");
            }
            System.out.println();
        }
        /**
         * 课程		b	c	a
         javase	90	null	80
         oracle	null	95      100
         */

        System.out.println("===========转换===========");
        Table<String, String, Integer> tables2 = Tables.transpose(tables);
        //所有的行数据
        Set<Cell<String, String, Integer>> cells2 = tables2.cellSet();
        for (Cell<String, String, Integer> temp : cells2) {
            System.out.println(temp.getRowKey() + ":" + temp.getColumnKey() + ":" + temp.getValue());
        }
        /**
         *  javase:b:90
         oracle:c:95
         oracle:a:100
         */
    }


}
