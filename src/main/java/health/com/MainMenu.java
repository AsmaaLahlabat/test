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
            System.out.println("1. Program Management");
            System.out.println("2. Client Interaction");
            System.out.println("3. Progress Tracking");
            System.out.println("4. Notifications and Updates");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> programManagementFeature(scanner);
                case 2 -> clientInteractionFeature(scanner);
                case 3 -> progressTrackingFeature(scanner);
                case 4 -> notificationsAndUpdatesFeature(scanner);
                case 5 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void programManagementFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Program Management ====");
            System.out.println("1. View All Programs");
            System.out.println("2. Add New Program");
            System.out.println("3. Update Program");
            System.out.println("4. Delete Program");
            System.out.println("5. Back to Instructor Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> InstructorManagement.listPrograms();
                case 2 -> {
                    System.out.print("Enter Program Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Duration: ");
                    String duration = scanner.nextLine();
                    System.out.print("Enter Level: ");
                    String level = scanner.nextLine();
                    System.out.print("Enter Goals: ");
                    String goals = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Materials: ");
                    String materials = scanner.nextLine();
                    InstructorManagement.addProgram(title, duration, level, goals, price, materials);
                }
                case 3 -> {
                    System.out.print("Enter Program Title to Update: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter New Duration: ");
                    String duration = scanner.nextLine();
                    System.out.print("Enter New Level: ");
                    String level = scanner.nextLine();
                    System.out.print("Enter New Goals: ");
                    String goals = scanner.nextLine();
                    System.out.print("Enter New Price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Materials: ");
                    String materials = scanner.nextLine();
                    InstructorManagement.updateProgram(title, duration, level, goals, price, materials);
                }
                case 4 -> {
                    System.out.print("Enter Program Title to Delete: ");
                    String title = scanner.nextLine();
                    InstructorManagement.deleteProgram(title);
                }
                case 5 -> {
                    System.out.println("Returning to Instructor Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void clientInteractionFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Client Interaction ====");
            System.out.println("1. Send Message to Client");
            System.out.println("2. Provide Progress Report");
            System.out.println("3. View All Messages");
            System.out.println("4. View All Progress Reports");
            System.out.println("5. Back to Instructor Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();
                    System.out.print("Enter Message: ");
                    String message = scanner.nextLine();
                    ClientInteraction.sendMessage(clientName, message);
                }
                case 2 -> {
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();
                    System.out.print("Enter Progress Report: ");
                    String report = scanner.nextLine();
                    ClientInteraction.provideProgressReport(clientName, report);
                }
                case 3 -> ClientInteraction.listClientMessages();
                case 4 -> ClientInteraction.listProgressReports();
                case 5 -> {
                    System.out.println("Returning to Instructor Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void progressTrackingFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Progress Tracking ====");
            System.out.println("1. Monitor Client Progress");
            System.out.println("2. Send Motivational Reminder");
            System.out.println("3. Back to Instructor Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    ProgressTracking.listProgressReports();
                }
                case 2 -> {
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();
                    System.out.print("Enter Reminder Message: ");
                    String reminder = scanner.nextLine();
                    ProgressTracking.sendMotivationalReminder(clientName, reminder);
                }
                case 3 -> {
                    System.out.println("Returning to Instructor Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void notificationsAndUpdatesFeature(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Notifications and Updates ====");
            System.out.println("1. Notify Clients About Schedule Changes");
            System.out.println("2. Announce New Programs or Offers");
            System.out.println("3. View Sent Notifications");
            System.out.println("4. Edit a Notification");
            System.out.println("5. Delete a Notification");
            System.out.println("6. Back to Instructor Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> notifyClients(scanner);
                case 2 -> announceProgram(scanner);
                case 3 -> ClientCommunication.viewNotifications();
                case 4 -> editNotification(scanner);
                case 5 -> deleteNotification(scanner);
                case 6 -> {
                    System.out.println("Returning to Instructor Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void notifyClients(Scanner scanner) {
        System.out.println("Notify Clients:");
        System.out.println("1. All Clients");
        System.out.println("2. Clients of a Specific Program");
        System.out.print("Enter your choice: ");
        int targetChoice = scanner.nextInt();
        scanner.nextLine();

        String target = "ALL_CLIENTS";
        if (targetChoice == 2) {
            System.out.print("Enter Program Name: ");
            target = scanner.nextLine();
        }

        System.out.print("Enter Notification Message: ");
        String message = scanner.nextLine();
        ClientCommunication.sendMessage(target, message);
    }

    private static void announceProgram(Scanner scanner) {
        System.out.print("Enter Announcement Message: ");
        String announcement = scanner.nextLine();
        ClientCommunication.sendMessage("ALL_CLIENTS", announcement);
    }

    private static void editNotification(Scanner scanner) {
        ClientCommunication.viewNotifications();
        System.out.print("Enter Notification Number to Edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Enter the New Message: ");
        String newMessage = scanner.nextLine();
        ClientCommunication.editNotification(index, newMessage);
    }

    private static void deleteNotification(Scanner scanner) {
        ClientCommunication.viewNotifications();
        System.out.print("Enter Notification Number to Delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        ClientCommunication.deleteNotification(index);
    }




    private static void clientMenu(Scanner scanner) {
        ClientAccount account = new ClientAccount();
        while (true) {
            System.out.println("\n==== Client Account Management ====");
            System.out.println("1. Create Profile");
            System.out.println("2. Update Dietary Preferences");
            System.out.println("3. View Profile");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Fitness Goal: ");
                    String goal = scanner.nextLine();
                    System.out.print("Enter Dietary Preferences: ");
                    String preferences = scanner.nextLine();

                    System.out.println(account.createProfile(name, age, goal, preferences));
                }
                case 2 -> {
                    System.out.print("Enter New Dietary Preferences: ");
                    String preferences = scanner.nextLine();
                    System.out.println(account.updateDietaryPreferences(preferences));
                }
                case 3 -> System.out.println(account.viewProfile());
                case 4 -> {
                    System.out.println("Returning to Main Menu...");
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

                    Login.addUser(username, password, role);

                    System.out.println("User successfully added and updated in the system.");
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