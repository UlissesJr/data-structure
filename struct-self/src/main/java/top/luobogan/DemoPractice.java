package top.luobogan;

import lombok.Data;

/**
 * Created by LuoboGan
 * Date:2022/11/17
 */
public class DemoPractice {

    @Data
    static class User {
        String name;
        String gender;
    }

    public static void main(String[] args) {
        DemoPractice pt = new DemoPractice();

        User hollis = new User();
        hollis.setName("Hollis");
        hollis.setGender("Male");
        pt.pass(hollis);
        System.out.println("print in main , user is " + hollis);
    }

    public void pass(User user) {
        user.setName("hollischuang");
        System.out.println("print in pass , user is " + user);
    }

}
