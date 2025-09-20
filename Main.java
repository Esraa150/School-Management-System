
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Data data = new Data();
		Admin admin = new Admin("MainAdmin", 1, "admin123", data);
		
		while(true){
		    System.out.println("\n===== School Management System =====");
		    System.out.println("1- Login as Admin");
		    System.out.println("2- Login as Student");
		    System.out.println("3- Login as Teacher");
		    System.out.println("4- Exit");
		    System.out.println("Choose option: ");
		    int choice = scanner.nextInt();
		    scanner.nextLine();
		    if(choice==4){
		        break;
		    }
		    switch (choice){
		        case 1:
		            System.out.println("Enter Admin ID: ");
		            int AdminId = scanner.nextInt();
		            scanner.nextLine();
		            System.out.println("Enter Admin password: ");
		            String AdminPass = scanner.nextLine();
		            if(AdminId == admin.getId() && AdminPass.equals(admin.getPassword())){
		                adminMenu(scanner, admin, data);
		            }
		            else{
		                System.out.println("wrong Id or Password. try again!");
		            }
		            break;
		        
		        case 2:
		            System.out.println("Enter Student Id: ");
		            int StudentId = scanner.nextInt();
		            scanner.nextLine();
		            System.out.println("Enter Student password: ");
		            String StudentPass = scanner.nextLine();
		            boolean LoggedStudent = false;
		            Student student = null;
		            for(int j=0; j<data.getStudents().size(); j++){
		                if(StudentId == data.getStudents().get(j).getId() && StudentPass.equals(data.getStudents().get(j).getPassword())){
		                    student = data.getStudents().get(j);
		                    LoggedStudent = true;
		                    break;
		                }
		            }
		            if(LoggedStudent == true){
		                studentMenu(scanner, student, data);
		            }
		            else{
		                System.out.println("Invalid Student!");
		            }
		            break;
		        case 3:
		            System.out.println("Enter Teacher Id: ");
		            int TeacherId = scanner.nextInt();
		            scanner.nextLine();
		            System.out.println("Enter Teacher password: ");
		            String TeacherPass = scanner.nextLine();
		            boolean LoggedTeacher = false;
		            Teacher teacher = null;
		            for(int j=0; j<data.getTeachers().size(); j++){
		                if(TeacherId == data.getTeachers().get(j).getId() && TeacherPass.equals(data.getTeachers().get(j).getPassword())){
		                    teacher = data.getTeachers().get(j);
		                    LoggedTeacher = true;
		                    break;
		                }
		            }
		            if(LoggedTeacher == true){
		                teacherMenu(scanner, teacher);
		            }
		            else{
		                System.out.println("Invalid Teacher!");
		            }
		            break;
		    }
		}
	}
	
	
	// admin Menu
		private static void adminMenu(Scanner scanner, Admin admin, Data data){
		    while(true){
		                System.out.println("\n--- Admin Menu ---");
		                System.out.println("1- Add Student");
		                System.out.println("2- Add Teacher");
		                System.out.println("3- Add Course");
		                System.out.println("4- Back");
		                System.out.println("Choose option: ");
		                int option = scanner.nextInt();
		                scanner.nextLine();
		                switch (option){
		                    case 1:
		                        System.out.println("Student name: ");
		                        String stName = scanner.nextLine();
		                        System.out.println("Student id: ");
		                        int stId = scanner.nextInt();
		                        scanner.nextLine();
		                        System.out.println("Student password: ");
		                        String stPass = scanner.nextLine();
		                        admin.addStudent(stName, stId, stPass);
		                        System.out.println("Student added!");
		                        break;
		                    case 2:
		                        System.out.println("Teacher name: ");
		                        String tName = scanner.nextLine();
		                        System.out.println("Teacher id: ");
		                        int tId = scanner.nextInt();
		                        scanner.nextLine();
		                        System.out.println("Teacher password: ");
		                        String tPass = scanner.nextLine();
		                        admin.addTeacher(tName, tId, tPass);
		                        System.out.println("Teacher added!");
		                        break;
		                    case 3:
		                        System.out.println("Course name: ");
		                        String cName = scanner.nextLine();
		                        System.out.println("Teacher id: ");
		                        int cId = scanner.nextInt();
		                        scanner.nextLine();
		                        for(int j=0; j<data.getTeachers().size(); j++){
		                            if(cId == data.getTeachers().get(j).getId()){
		                                admin.addCourse(cName, data.getTeachers().get(j));
		                                System.out.println("Course added!");
		                                break;
		                            }
		                        }
		                        break;
		                    case 4:
		                        return;
		                }
		            }
		}
		
		
		// student Menu
		private static void studentMenu(Scanner scanner, Student student, Data data){
		    while(true){
		                    System.out.println("\n--- Student Menu ---");
		                    System.out.println("1- View all Courses");
		                    System.out.println("2- View Enrolled Courses");
		                    System.out.println("3- Enroll in Course");
		                    System.out.println("4- back");
		                    System.out.println("Choose option: ");
		                    int option = scanner.nextInt();
		                    switch (option){
		                        case 1:
		                            for(int j=0; j<data.getCourses().size(); j++){
		                                System.out.println("- " + data.getCourses().get(j).getCourseName());
		                            }
		                            break;
		                        case 2:
		                            for(int j=0; j<student.getEnrolledCourses().size(); j++){
		                                System.out.println("- " + student.getEnrolledCourses().get(j).getCourseName());
		                            }
		                            break;
		                        case 3:
		                            for(int j=0; j<data.getCourses().size(); j++){
		                                System.out.println(j + "- " + data.getCourses().get(j).getCourseName());
		                            }
		                            System.out.println("Choose index: ");
		                            int ind = scanner.nextInt();
		                            scanner.nextLine();
		                            if(ind<0 || ind>=data.getCourses().size()){
		                                System.out.println("invalid index!");
		                                break;
		                            }
		                            student.addCourse(data.getCourses().get(ind));
		                            data.getCourses().get(ind).enrollStudent(student);
		                            System.out.println("Enrolled succesfully!");
		                            break;
		                        case 4:
		                            return;
		                    }
		                }
		}
		
		
		// teacher Menu
		private static void teacherMenu(Scanner scanner, Teacher teacher){
		    while(true){
		                    System.out.println("\n--- Teacher Menu ---");
		                    System.out.println("1- View My Courses");
		                    System.out.println("2- View Students Enrolled in Course");
		                    System.out.println("3- back");
		                    System.out.println("Choose option: ");
		                    int option = scanner.nextInt();
		                    scanner.nextLine();
		                    switch (option){
		                        case 1:
		                            System.out.println("Courses you teach: ");
		                            for(int j=0; j<teacher.getCourses().size(); j++){
		                               System.out.println("- " + teacher.getCourses().get(j).getCourseName());
		                            }
		                            break;
                                case 2:
                                    for(int j=0; j<teacher.getCourses().size(); j++){
		                               System.out.println(j + "- " + teacher.getCourses().get(j).getCourseName());
		                            }
                                    System.out.println("choose a course");
                                    int ind = scanner.nextInt();
                                    scanner.nextLine();
                                    Course c = teacher.getCourses().get(ind);
                                    System.out.println("Students Enrolled in " + c.getCourseName());
                                    for(int j=0; j<c.getEnrolledStudents().size(); j++){
                                        System.out.println(j + "- " + c.getEnrolledStudents().get(j).getName());
                                    }
                                    break;
                                case 3:
                                    return;
		                    }
		                }
		}
}
