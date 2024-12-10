package health.com.AcceptanceTest;

import health.com.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static health.com.Login.users;

public class LoginTest {
    Login login=new Login();
    boolean isValid=false;
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {



    }

    @When("the user enters valid credentials {string} and {string}")
    public void theUserEntersValidCredentialsAnd(String string, String string2) {
       isValid= login.isValid(string);
    login.hashCode();
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        Assert.assertTrue(isValid);
    }



    @When("the user enters invalid credentials {string} and {string}")
    public void theUserEntersInvalidCredentialsAnd(String string, String string2) {
        Assert.assertTrue(true);

    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(true);
    }
}
