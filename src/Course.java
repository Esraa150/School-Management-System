
import java.util.List;
import java.util.ArrayList;

public class Course{
    private String courseName;
    private List<Student> enrolledStudents;
    private Teacher teacher;
    
    public Course(String courseName, Teacher teacher){
        this.courseName = courseName;
        this.teacher = teacher;
        this.enrolledStudents = new ArrayList<>();
    }
    public void enrollStudent(Student student){
        enrolledStudents.add(student);
    }
    public List<Student> getEnrolledStudents(){
        return enrolledStudents;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public Teacher getTeacher(){
        return teacher;
    }
}
