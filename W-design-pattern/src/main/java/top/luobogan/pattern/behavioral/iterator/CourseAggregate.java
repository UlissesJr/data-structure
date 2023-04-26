package top.luobogan.pattern.behavioral.iterator;

/**
 * Created by luobogan.
 */
public interface CourseAggregate {

    void addCourse(Course course);
    void removeCourse(Course course);

    CourseIterator getCourseIterator();



}
