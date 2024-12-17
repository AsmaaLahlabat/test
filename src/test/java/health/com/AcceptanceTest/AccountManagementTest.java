package health.com.AcceptanceTest;

import health.com.ClientAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountManagementTest {
    private ClientAccount account;
    private String result;

    @Given("the client is on the account management page")
    public void theClientIsOnTheAccountManagementPage() {
        account = new ClientAccount();
        System.out.println("Client navigates to Account Management Page.");
    }

    @When("the client enters valid personal details {string}, {string}, {string}, {string}")
    public void theClientEntersValidPersonalDetails(String name, String age, String fitnessGoal, String dietaryPreferences) {
        result = account.createProfile(name, Integer.parseInt(age), fitnessGoal, dietaryPreferences);
    }

    @When("the client enters invalid age {string}")
    public void theClientEntersInvalidAge(String age) {
        result = account.createProfile("John Doe", Integer.parseInt(age), "Weight Loss", "No Restrictions");
    }

    @When("the client submits the profile with missing details")
    public void theClientSubmitsTheProfileWithMissingDetails() {
        result = account.createProfile("", -1, "", "");
    }

    @When("the client updates dietary preferences to {string}")
    public void theClientUpdatesDietaryPreferencesTo(String newPreferences) {
        result = account.updateDietaryPreferences(newPreferences);
    }

    @When("the client views their profile")
    public void theClientViewsTheirProfile() {
        result = account.viewProfile();
    }

    @Then("the system should display {string}")
    public void theSystemShouldDisplay(String expectedMessage) {
        assertEquals(expectedMessage, result);
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String expectedError) {
        assertEquals(expectedError, result);
    }
}
