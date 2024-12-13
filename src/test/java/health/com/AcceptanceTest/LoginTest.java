package health.com.AcceptanceTest;

import health.com.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTest {
    private String username;
    private String password;
    private boolean loginSuccess;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        System.out.println("User navigates to the login page.");
    }

    @When("the user enters valid credentials {string} and {string}")
    public void theUserEntersValidCredentialsAnd(String username, String password) {
        this.username = username;
        this.password = password;
        loginSuccess = Login.login(username, password);
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        if (loginSuccess) {
            System.out.println("Login successful! Welcome, " + username + "!");
        } else {
            System.out.println("Login failed! Invalid credentials.");
        }
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void theUserEntersInvalidCredentialsAnd(String username, String password) {
        this.username = username;
        this.password = password;
        loginSuccess = Login.login(username, password);
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        if (!loginSuccess) {
            System.out.println("Error: Invalid username or password.");
        }
    }
}
