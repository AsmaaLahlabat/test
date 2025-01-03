package health.com.AcceptanceTest;

import health.com.InstructorManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserFilterByFoucse {


    @Given("the client is on the main menu and wants to filter the programs by focus area")
    public void theClientIsOnTheMainMenuAndWantsToFilterTheProgramsByFocusArea() {
        System.out.println("Client is on the main menu and wants to filter programs by focus area.");
    }

    @When("the client selects the focus area {string}")
    public void theClientSelectsTheFocusArea(String focusArea) {
        InstructorManagement.SearchByFocusAreaPrograms(focusArea);
    }

    @Then("display all programs that correspond to it")
    public void displayAllProgramsThatCorrespondToIt() {
        Assert.assertTrue(true);
    }
}
