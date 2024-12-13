package health.com;

import java.util.List;
import java.util.ArrayList;


public class Login {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "admin123"));
    }

    public static boolean login(String username, String password) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    public static void addUser(String username, String password) {
        users.add(new User(username, password));
        System.out.println("User added successfully: " + username);
    }

    public static void listUsers() {
        System.out.println("\nRegistered Users:");
        users.forEach(user -> System.out.println("Username: " + user.getUsername()));
    }

}
