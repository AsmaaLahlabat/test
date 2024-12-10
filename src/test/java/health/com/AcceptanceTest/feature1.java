package health.com.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class feature1 {
    private static final List<User> users = new ArrayList<>();
    private String loginMessage;

    static {
        users.add(new User("admin", "admin123"));
        users.add(new User("user1", "password1"));
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("User navigates to the login page.");
    }

    @When("the user enters valid credentials {string} and {string}")
    public void the_user_enters_valid_credentials(String username, String password) {
        boolean isValid = users.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
        if (isValid) {
            loginMessage = "Login Successful! Welcome, " + username + "!";
        } else {
            loginMessage = "Login Failed! Invalid credentials.";
        }
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        if (loginMessage.startsWith("Login Successful")) {
            System.out.println(loginMessage);
        } else {
            throw new AssertionError("User was not redirected to the dashboard.");
        }
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void the_user_enters_invalid_credentials(String username, String password) {
        boolean isValid = users.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
        if (!isValid) {
            loginMessage = "Login Failed! Invalid credentials.";
        } else {
            loginMessage = "Login Successful! Welcome, " + username + "!";
        }
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        if (loginMessage.equals("Login Failed! Invalid credentials.")) {
            System.out.println(loginMessage);
        } else {
            throw new AssertionError("Error message was not displayed.");
        }
    }
}

class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
