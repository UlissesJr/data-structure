package top.luobogan.principle.dependenceinversion;

/**
 * Created by luobogan
 */
public class FECourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("Geely在学习FE课程");
    }

}
