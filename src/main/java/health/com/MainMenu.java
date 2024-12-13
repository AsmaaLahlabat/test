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
                    User loggedInUser = loginFeature(scanner);
                    if (loggedInUser != null) {
                        postLoginMenu(scanner, loggedInUser);
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

    private static User loginFeature(Scanner scanner) {
        System.out.print("\nEnter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User user = Login.login(username, password);
        if (user != null) {
            System.out.println("Login Successful! Welcome, " + user.getUsername() + " (" + user.getRole() + ")");
        } else {
            System.out.println("Login Failed! Invalid credentials.");
        }
        return user;
    }

    private static void postLoginMenu(Scanner scanner, User user) {
        switch (user.getRole()) {
            case "Admin" -> adminMenu(scanner);
            case "Instructor" -> instructorMenu(scanner);
            case "Client" -> clientMenu(scanner);
            default -> System.out.println("Invalid role detected!");
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Admin Menu ====");
            System.out.println("1. Program Monitoring");
            System.out.println("2. Content Management");
            System.out.println("3. User Management");
            System.out.println("4. Subscription Management");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> programMonitoringFeature(scanner);
                case 2 -> contentManagementFeature(scanner);
                case 3 -> userManagementFeature(scanner);
                case 4 -> subscriptionManagementFeature(scanner);
                case 5 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void instructorMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Instructor Menu ====");
            System.out.println("1. View Assigned Programs");
            System.out.println("2. Manage Content");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Viewing assigned programs...");
                case 2 -> System.out.println("Managing content...");
                case 3 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void clientMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Client Menu ====");
            System.out.println("1. View Subscriptions");
            System.out.println("2. Enroll in a Program");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Viewing subscriptions...");
                case 2 -> System.out.println("Enrolling in a program...");
                case 3 -> {
                    System.out.println("Logging out...");
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
            System.out.println("6. Back to Admin Menu");
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
                    System.out.println("Returning to Admin Menu...");
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
            System.out.println("6. Back to Admin Menu");
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
                    System.out.println("Returning to Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void userManagementFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== User Management Menu ====");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Deactivate User");
            System.out.println("4. Approve Registration");
            System.out.println("5. Monitor User Activities");
            System.out.println("6. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Role (Admin/Instructor/Client): ");
                    String role = scanner.nextLine();
                    UserManagement.addUser(username, password, role);
                }
                case 2 -> {
                    System.out.print("Enter Username to Update: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter New Password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter New Role: ");
                    String newRole = scanner.nextLine();
                    UserManagement.updateUser(username, newPassword, newRole);
                }
                case 3 -> {
                    System.out.print("Enter Username to Deactivate: ");
                    String username = scanner.nextLine();
                    UserManagement.deactivateUser(username);
                }
                case 4 -> {
                    UserManagement.showPendingRegistrations();
                    System.out.print("Enter Username to Approve: ");
                    String username = scanner.nextLine();
                    if (UserManagement.approveRegistration(username)) {
                        System.out.println("Registration approved successfully for: " + username);
                    } else {
                        System.out.println("Registration not found for: " + username);
                    }
                }

                case 5 -> UserManagement.monitorActivities();
                case 6 -> {
                    System.out.println("Returning to Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void subscriptionManagementFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Subscription Management ====");
            System.out.println("1. View Subscription Plans");
            System.out.println("2. Add Subscription Plan");
            System.out.println("3. Update Subscription Plan");
            System.out.println("4. Delete Subscription Plan");
            System.out.println("5. Back to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> SubscriptionManagement.listPlans();
                case 2 -> {
                    System.out.print("Enter Plan Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    SubscriptionManagement.addSubscriptionPlan(name, price);
                }
                case 3 -> {
                    System.out.print("Enter Plan Name to Update: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Price: ");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine();
                    SubscriptionManagement.updateSubscriptionPlan(name, newPrice);
                }
                case 4 -> {
                    System.out.print("Enter Plan Name to Delete: ");
                    String name = scanner.nextLine();
                    SubscriptionManagement.deleteSubscriptionPlan(name);
                }
                case 5 -> {
                    System.out.println("Returning to Admin Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}