package top.luobogan.principle.demeter;


/**
 * Created by luobogan
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader){
        teamLeader.checkNumberOfCourses();
    }

}
