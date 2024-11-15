import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {
    private Map<String, Student> studentDatabase = new HashMap<>();

    public void addStudent(Student student) {
        studentDatabase.put(student.getRollNumber(), student);
        System.out.println("Student added: " + student.getDetails());
    }

    public void updateStudent(String rollNumber, Map<String, Integer> newSubjectMarks) {
        Student student = studentDatabase.get(rollNumber);
        if (student != null) {
            student = new Student(student.getName(), rollNumber, newSubjectMarks); // recreate student with updated marks
            studentDatabase.put(rollNumber, student); // update in database
            System.out.println("Student updated: " + student.getDetails());
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public void deleteStudent(String rollNumber) {
        if (studentDatabase.remove(rollNumber) != null) {
            System.out.println("Student with Roll Number " + rollNumber + " removed.");
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    public Student getStudent(String rollNumber) {
        return studentDatabase.get(rollNumber);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentDatabase.values());
    }
}
