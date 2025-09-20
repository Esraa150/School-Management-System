
import java.util.List;
import java.util.ArrayList;

public class Teacher extends User{
    private List<Course> courses;
    
    public Teacher(String name, int id, String password){
        super(name, id, password);
        this.courses = new ArrayList<>();
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public List<Course> getCourses(){
        return courses;
    }
    public List<Student> getStudentsEnrolledInCourse(Course course){
        return course.getEnrolledStudents();
    }
}
