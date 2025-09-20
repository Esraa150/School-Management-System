
import java.util.List;
import java.util.ArrayList;

public class Data{
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    
    public void addStudent(Student s){
        students.add(s);
    }
    public void addTeacher(Teacher t){
        teachers.add(t);
    }
    public void addCourse(Course c){
        courses.add(c);
    }
    public List<Student> getStudents(){
        return students;
    }
    public List<Teacher> getTeachers(){
        return teachers;
    }
    public List<Course> getCourses(){
        return courses;
    }
}
