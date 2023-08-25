import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // This class represents the main program that manages attendance records.

    private Map<String, Boolean> attendanceRecords; // Map to store student attendance

    public Main() {
        attendanceRecords = new HashMap<>(); // Initialize the attendance record map
    }

    // Method to mark attendance for a student
    public void markAttendance(String studentName, boolean isPresent) {
        attendanceRecords.put(studentName, isPresent); // Store attendance status
    }

    // Method to print attendance report
    public void printAttendanceReport() {
        System.out.println("Attendance Report:");
        for (Map.Entry<String, Boolean> entry : attendanceRecords.entrySet()) {
            String studentName = entry.getKey(); // Get student name
            boolean isPresent = entry.getValue(); // Get attendance status
            String status = isPresent ? "Present" : "Absent"; // Convert status to text
            System.out.println(studentName + ": " + status); // Print student's attendance
        }
    }

    public static void main(String[] args) {
        Main ams = new Main(); // Instantiate the attendance management system
        Scanner scanner = new Scanner(System.in); // Initialize scanner for user input

        while (true) {
            System.out.println("1. Mark Attendance");
            System.out.println("2. Print Attendance Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine(); // Read student's name
                    System.out.print("Is the student present? (true/false): ");
                    boolean isPresent = scanner.nextBoolean(); // Read attendance status
                    ams.markAttendance(studentName, isPresent); // Mark attendance
                    break;
                case 2:
                    ams.printAttendanceReport(); // Print attendance report
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close(); // Close the scanner
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
