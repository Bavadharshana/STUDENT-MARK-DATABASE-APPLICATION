import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private DatabaseManager databaseManager;
    private Scanner scanner;

    public UserInterface(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();
        
        Map<String, Integer> subjectMarks = new HashMap<>();
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter Subject Name: ");
            String subject = scanner.nextLine();
            System.out.print("Enter Marks: ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            subjectMarks.put(subject, marks);
        }

        Student student = new Student(name, rollNumber, subjectMarks);
        databaseManager.addStudent(student);
    }

    public void updateStudent() {
        System.out.print("Enter Roll Number of Student to Update: ");
        String rollNumber = scanner.nextLine();

        Map<String, Integer> newSubjectMarks = new HashMap<>();
        System.out.print("Enter number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter Subject Name: ");
            String subject = scanner.nextLine();
            System.out.print("Enter Marks: ");
            int marks = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            newSubjectMarks.put(subject, marks);
        }

        databaseManager.updateStudent(rollNumber, newSubjectMarks);
    }

    public void deleteStudent() {
        System.out.print("Enter Roll Number of Student to Delete: ");
        String rollNumber = scanner.nextLine();
        databaseManager.deleteStudent(rollNumber);
    }

    public void displayStudent() {
        System.out.print("Enter Roll Number of Student to View: ");
        String rollNumber = scanner.nextLine();
        Student student = databaseManager.getStudent(rollNumber);
        if (student != null) {
            System.out.println(student.getDetails());
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public void displayAllStudents() {
        for (Student student : databaseManager.getAllStudents()) {
            System.out.println(student.getDetails());
        }
    }
}
