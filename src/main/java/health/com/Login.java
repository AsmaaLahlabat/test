package health.com;

import java.util.List;
import java.util.ArrayList;

public class Login {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "admin123", "Admin"));
        users.add(new User("trainer", "trainer123", "Instructor"));
        users.add(new User("client", "client123", "Client"));
    }

    public static User login(String username, String password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public static void addUser(String username, String password, String role) {
        users.add(new User(username, password, role));
        System.out.println("User added successfully: " + username + " (" + role + ")");
    }

    public static void listUsers() {
        System.out.println("\nRegistered Users:");
        users.forEach(user -> System.out.println("Username: " + user.getUsername() + ", Role: " + user.getRole()));
    }
}
