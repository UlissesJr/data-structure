package top.luobogan.creater.prototype;

/**
 * Created by LuoboGan
 * Date:2021/10/26
 */
public class User implements Cloneable{

    private String username;
    private Integer age;

    public User() {
        System.out.println("User对象创建.");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = new User();
        user.setUsername(this.username);
        user.setAge(this.age);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
