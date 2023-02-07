package juc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author kingdee
 */
public class 多线程遍历一个List {
    private static final List<Integer> LIST = Arrays.asList(1,2,3,4,5,6);

    public static void main(String[] args){
        List<User> list = new ArrayList<>();
        //定义三个用户对象
        User user1 = new User();
        user1.setUserName("huxiansen");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setUserName("huxianseng");
        user2.setPassword("123456");
        User user3 = new User();
        user3.setUserName("huxiansen");
        user3.setPassword("12345");
        //添加用户到集合中
        list.add(user1);
        list.add(user2);
        list.add(user3);
        //在集合中查询用户名为huxiansen的集合
        List<User> userList = list.stream().filter(user -> "huxiansen".equals(user.getUserName())).collect(Collectors.toList());
        //在集合中查询出第一个用户密码为123456的用户
        Optional<User> user = list.stream().filter(userTemp -> "123456".equals(userTemp.getPassword())).findFirst();
        System.out.println(userList);
        System.out.println(user);
    }
    static class User {
        String userName;
        String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    static class Thread1 implements Runnable{

        @Override
        public void run() {
            for (Integer i : LIST) {
                System.out.println("Thread1-----" + i);

                try {
                    if (i == 3) {
                        java.lang.Thread.sleep(90000000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            LIST.iterator();
            for (Integer i : LIST) {
                System.out.println("Thread2-----------" + i);
            }
        }
    }

}

