package health.com.AcceptanceTest;

import health.com.Login;
import health.com.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
    private String username;
    private String password;
    private User loggedInUser;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        System.out.println("User navigates to the login page.");
    }

    @When("the user enters valid credentials {string} and {string}")
    public void theUserEntersValidCredentialsAnd(String username, String password) {
        this.username = username;
        this.password = password;
        loggedInUser = Login.login(username, password);
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        if (loggedInUser != null) {
            System.out.println("Login successful! Welcome, " + loggedInUser.getUsername() + " (" + loggedInUser.getRole() + ")");
        } else {
            System.out.println("Login failed! Invalid credentials.");
        }
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void theUserEntersInvalidCredentialsAnd(String username, String password) {
        this.username = username;
        this.password = password;
        loggedInUser = Login.login(username, password);
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        if (loggedInUser == null) {
            System.out.println("Error: Invalid username or password.");
        }
    }
}
