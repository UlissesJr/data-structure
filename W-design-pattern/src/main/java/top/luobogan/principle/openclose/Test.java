package top.luobogan.principle.openclose;

/**
 * Created by Luobogan
 */
public class Test {
    public static void main(String[] args) {

//        ICourse course = new JavaCourse(96, "Java从零到企业级电商开发", 348d);
//        System.out.println("课程ID:" + course.getId() + " 课程名称:" + course.getName() + " 课程原价:" + course.getPrice() + "元");


        ICourse iCourse = new JavaDiscountCourse(96, "Java从零到企业级电商开发", 348d);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程ID:" + javaCourse.getId() + " 课程名称:" + javaCourse.getName() + " 课程原价:" + javaCourse.getPrice() + " 课程折后价格:" + javaCourse.getDiscountPrice() + "元");
    }
}
