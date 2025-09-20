import java.util.List;
import java.util.ArrayList;

public class Student extends User{
    private List<Course> enrolledCourses;
    
    public Student(String name, int id, String password){
        super(name, id, password);
        this.enrolledCourses = new ArrayList<>();
    }
    public void addCourse(Course course){
        enrolledCourses.add(course);
    }
    public List<Course> getEnrolledCourses(){
        return enrolledCourses;
    }
}
