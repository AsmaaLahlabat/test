package health.com.AcceptanceTest;

import health.com.Login;
import health.com.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

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

    @Then("the user should be redirected to the admin dashboard")
    public void theUserShouldBeRedirectedToTheAdminDashboard() {
        assertNotNull("Login failed, user is null", loggedInUser);
        assertEquals("User role mismatch", "Admin", loggedInUser.getRole());
        System.out.println("Redirected to Admin Dashboard.");
    }

    @Then("the user should be redirected to the instructor dashboard")
    public void theUserShouldBeRedirectedToTheInstructorDashboard() {
        assertNotNull("Login failed, user is null", loggedInUser);
        assertEquals("User role mismatch", "Instructor", loggedInUser.getRole());
        System.out.println("Redirected to Instructor Dashboard.");
    }

    @Then("the user should be redirected to the client dashboard")
    public void theUserShouldBeRedirectedToTheClientDashboard() {
        assertNotNull("Login failed, user is null", loggedInUser);
        assertEquals("User role mismatch", "Client", loggedInUser.getRole());
        System.out.println("Redirected to Client Dashboard.");
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void theUserEntersInvalidCredentialsAnd(String username, String password) {
        this.username = username;
        this.password = password;
        loggedInUser = Login.login(username, password);
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        assertNull("Login succeeded with invalid credentials", loggedInUser);
        System.out.println("Error: Invalid username or password.");
    }
}