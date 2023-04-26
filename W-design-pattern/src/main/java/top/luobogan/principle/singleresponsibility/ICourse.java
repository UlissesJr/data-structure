package top.luobogan.principle.singleresponsibility;

/**
 * Created by luobogan
 */
public interface ICourse {
    String getCourseName();
    byte[] getCourseVideo();

    void studyCourse();
    void refundCourse();

}
