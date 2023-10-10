package demo;


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wangyanji
 * @Date 2023/8/30 18:09
 * @Version 1.0
 */
public class Excel读取 {


}


 class ReadExcel {
    public static void main(String[] args) {

        String a = "1,2,3,i am";
        List<String> s =  new ArrayList<String>(){{
            add("1");
            add("2");
        }};
        StringBuilder errMessage = new StringBuilder(null);



        try {
            // 创建文件输入流
            FileInputStream file = new FileInputStream(new File("文件路径"));

            // 创建Workbook对象，根据Excel文件类型选择对应的Workbook类
            Workbook workbook = WorkbookFactory.create(file);

            // 获取第一个Sheet页
            Sheet sheet = workbook.getSheetAt(0);

            // 遍历每一行
            for (Row row : sheet) {
                // 遍历每一个单元格
                for (Cell cell : row) {
                    // 获取单元格的值并输出
                    System.out.println(cell.toString());
                }
            }
            // 关闭文件输入流
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}