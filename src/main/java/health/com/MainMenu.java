package health.com;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    if (loginFeature(scanner)) {
                        postLoginMenu(scanner); // Show post-login menu if login succeeds
                    } else {
                        System.out.println("Login Failed! Please try again.");
                    }
                }
                case 2 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean loginFeature(Scanner scanner) {
        System.out.print("\nEnter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (Login.login(username, password)) {
            System.out.println("Login Successful! Welcome, " + username + "!");
            return true;
        } else {
            System.out.println("Login Failed! Invalid credentials.");
            return false;
        }
    }

    private static void postLoginMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Post Login Menu ====");
            System.out.println("1. Program Monitoring");
            System.out.println("2. Content Management");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> programMonitoringFeature(scanner);
                case 2 -> contentManagementFeature(scanner);
                case 3 -> {
                    System.out.println("Logging out... Returning to Main Menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void programMonitoringFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Program Monitoring ====");
            System.out.println("1. View All Programs");
            System.out.println("2. View Most Popular Program");
            System.out.println("3. Add New Program");
            System.out.println("4. Delete a Program");
            System.out.println("5. Update a Program");
            System.out.println("6. Back to Post Login Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> ProgramMonitoring.listPrograms();
                case 2 -> {
                    Program popular = ProgramMonitoring.getMostPopularProgram();
                    if (popular != null) {
                        System.out.println("\nMost Popular Program: " + popular.getTitle() +
                                " with " + popular.getEnrollments() + " enrollments.");
                    } else {
                        System.out.println("No programs available.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Program Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Enrollments: ");
                    int enrollments = scanner.nextInt();
                    System.out.print("Enter Attendance: ");
                    int attendance = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    ProgramMonitoring.addProgram(title, enrollments, attendance);
                }
                case 4 -> {
                    System.out.print("Enter the title of the program to delete: ");
                    String title = scanner.nextLine();
                    if (ProgramMonitoring.deleteProgram(title)) {
                        System.out.println("Program deleted successfully!");
                    } else {
                        System.out.println("Program not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter the title of the program to update: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter new Enrollments: ");
                    int enrollments = scanner.nextInt();
                    System.out.print("Enter new Attendance: ");
                    int attendance = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (ProgramMonitoring.updateProgram(title, enrollments, attendance)) {
                        System.out.println("Program updated successfully!");
                    } else {
                        System.out.println("Program not found.");
                    }
                }
                case 6 -> {
                    System.out.println("Returning to Post Login Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void contentManagementFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Content Management ====");
            System.out.println("1. View Pending Articles");
            System.out.println("2. Approve an Article");
            System.out.println("3. Reject an Article");
            System.out.println("4. View Complaints");
            System.out.println("5. Resolve a Complaint");
            System.out.println("6. Back to Post Login Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> ContentManagement.listPendingArticles();
                case 2 -> {
                    System.out.print("Enter Article Title to Approve: ");
                    String title = scanner.nextLine();
                    if (ContentManagement.approveArticle(title)) {
                        System.out.println("Article approved successfully!");
                    } else {
                        System.out.println("Article not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Article Title to Reject: ");
                    String title = scanner.nextLine();
                    if (ContentManagement.rejectArticle(title)) {
                        System.out.println("Article rejected successfully!");
                    } else {
                        System.out.println("Article not found.");
                    }
                }
                case 4 -> ContentManagement.listComplaints();
                case 5 -> {
                    System.out.print("Enter Complaint Title to Resolve: ");
                    String title = scanner.nextLine();
                    if (ContentManagement.resolveComplaint(title)) {
                        System.out.println("Complaint resolved successfully!");
                    } else {
                        System.out.println("Complaint not found.");
                    }
                }
                case 6 -> {
                    System.out.println("Returning to Post Login Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
