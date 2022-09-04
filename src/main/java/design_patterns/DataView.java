package design_patterns;

import design_patterns.user.User;
import design_patterns.user.impl.Student;
import design_patterns.user.impl.Teacher;
import design_patterns.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class DataView {
    List<User> userList = new ArrayList<>();

    public DataView() {
        userList.add(new Student("谢东", "重点班", "一年一班"));
        userList.add(new Student("windy", "重点班", "一年一班"));
        userList.add(new Student("大毛", "普通班", "二年三班"));
        userList.add(new Student("shing", "重点班", "三年二班"));

        userList.add(new Teacher("BK", "特级教师", "一年一班"));
        userList.add(new Teacher("BF", "特级教师", "一年一班"));
        userList.add(new Teacher("dangdang", "普通教师", "二年三班"));
        userList.add(new Teacher("Lisa", "实习教师", "三年二班"));

    }

    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }
}
