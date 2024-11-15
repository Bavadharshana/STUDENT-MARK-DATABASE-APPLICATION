import java.util.Map;

public class Student {
    private String name;
    private String rollNumber;
    private Map<String, Integer> subjectMarks;
    private int totalMarks;

    public Student(String name, String rollNumber, Map<String, Integer> subjectMarks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = subjectMarks;
        calculateTotalMarks();
    }

    // Method to calculate the total marks from the subject marks
    private void calculateTotalMarks() {
        totalMarks = subjectMarks.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public String getDetails() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Total Marks: " + totalMarks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }
}
