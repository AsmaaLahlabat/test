package health.com;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private static final List<User> users = new ArrayList<>();
    private static final List<String> pendingRegistrations = new ArrayList<>();

    static {
        users.add(new User("admin", "admin123", "Admin", true));
        users.add(new User("trainer", "trainer123", "Instructor", true));
        users.add(new User("client", "client123", "Client", true));


        UserManagement.requestRegistration("john_doe");
        UserManagement.requestRegistration("jane_smith");
        UserManagement.requestRegistration("new_instructor"); // إضافة المستخدم "new_instructor"
    }

//test
    public static List<User> getUsers() {
        return users;
    }

    public static List<String> getPendingRegistrations() {
        return pendingRegistrations;
    }

    public static void addUser(String username, String password, String role) {
        users.add(new User(username, password, role, true));
        System.out.println("User added successfully: " + username);
    }

    public static boolean updateUser(String username, String newPassword, String newRole) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                user.setPassword(newPassword);
                user.setRole(newRole);
                System.out.println("User updated successfully!");
                return true;
            }
        }
        System.out.println("User not found.");
        return false;
    }

    public static boolean deactivateUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                user.setActive(false);
                System.out.println("User deactivated successfully!");
                return true;
            }
        }
        System.out.println("User not found.");
        return false;
    }

    public static boolean approveRegistration(String username) {
        if (pendingRegistrations.remove(username)) {
            users.add(new User(username, "defaultPassword", "Instructor", true));
            System.out.println("Registration approved for: " + username);
            return true;
        }
        System.out.println("Registration not found.");
        return false;
    }

    public static void showPendingRegistrations() {
        if (pendingRegistrations.isEmpty()) {
            System.out.println("No pending registrations.");
        } else {
            System.out.println("\n==== Pending Registrations ====");
            for (String username : pendingRegistrations) {
                System.out.println("- " + username);
            }
        }
    }

    public static void monitorActivities() {
        System.out.println("User Activity Statistics:");
        for (User user : users) {
            System.out.println("User: " + user.getUsername() + ", Role: " + user.getRole() +
                    ", Active: " + user.isActive());
        }
    }

    public static void requestRegistration(String username) {
        pendingRegistrations.add(username);
        System.out.println("Registration request submitted for: " + username);
    }

    public static void listPendingRegistrations() {
        if (pendingRegistrations.isEmpty()) {
            System.out.println("No pending registrations.");
        } else {
            System.out.println("Pending Registrations:");
            for (String username : pendingRegistrations) {
                System.out.println("- " + username);
            }
        }
    }
}
