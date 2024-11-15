import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        UserInterface userInterface = new UserInterface(databaseManager);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Database Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    userInterface.addStudent();
                    break;
                case 2:
                    userInterface.updateStudent();
                    break;
                case 3:
                    userInterface.deleteStudent();
                    break;
                case 4:
                    userInterface.displayStudent();
                    break;
                case 5:
                    userInterface.displayAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
