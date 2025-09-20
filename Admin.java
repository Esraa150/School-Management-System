public class Admin extends User{
    private Data data;
    
    public Admin(String name, int id, String password, Data data){
        super(name, id, password);
        this.data = data;
    }
    public void addStudent(String name, int id, String password){
        Student s = new Student(name, id, password);
        data.addStudent(s);
    }
    public void addTeacher(String name, int id, String password){
        Teacher t = new Teacher(name, id, password);
        data.addTeacher(t);
    }
    public void addCourse(String courseName, Teacher teacher){
        Course c = new Course(courseName, teacher);
        data.addCourse(c);
        teacher.addCourse(c);
    }
}
