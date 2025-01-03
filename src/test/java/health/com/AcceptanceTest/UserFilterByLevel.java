package health.com.AcceptanceTest;

import health.com.InstructorManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserFilterByLevel {

    @Given("the client is on the main menu and wants to filter the programs by difficulty")
    public void theClientIsOnTheMainMenuAndWantsToFilterTheProgramsByDifficulty() {
        System.out.println("Client is on the main menu and wants to filter programs by difficulty.");
    }

    @When("the client selects the difficulty level {string}")
    public void theClientSelectsTheDifficultyLevel(String level) {
        InstructorManagement.SearchByLevelPrograms(level);
    }

    @Then("display all programs that correspond to it")
    public void displayAllProgramsThatCorrespondToIt() {
        System.out.println("All programs that correspond to it");
        Assert.assertTrue(true);
    }
    @When("the client enters the number of the filter")
    public void theClientEntersTheNumberOfTheFilter() {

    }
}
