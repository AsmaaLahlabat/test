package health.com.AcceptanceTest;

import health.com.ProgressTracking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressTrackingTest {

    @Given("the instructor is on the progress tracking page")
    public void theInstructorIsOnTheProgressTrackingPage() {
        System.out.println("Instructor navigates to the Progress Tracking Page.");
    }

    @Given("no progress reports are available")
    public void noProgressReportsAreAvailable() {
        ProgressTracking.clearProgressReports();
    }

    @When("the instructor selects to monitor client progress")
    public void theInstructorSelectsToMonitorClientProgress() {
        ProgressTracking.listProgressReports();
    }

    @Then("the system should display a message indicating no reports")
    public void theSystemShouldDisplayAMessageIndicatingNoReports() {
        System.out.println("No progress reports available.");
    }

    @Then("the system should display all client progress reports")
    public void theSystemShouldDisplayAllClientProgressReports() {
        System.out.println("Client progress reports displayed.");
    }

    @When("the instructor sends a motivational reminder to {string} with message {string}")
    public void theInstructorSendsAMotivationalReminderToWithMessage(String clientName, String message) {
        ProgressTracking.sendMotivationalReminder(clientName, message);
    }

    @Then("the system should confirm that the reminder was sent successfully")
    public void theSystemShouldConfirmThatTheReminderWasSentSuccessfully() {
        System.out.println("Motivational reminder sent successfully.");
    }

    @Then("the system should display an error indicating client not found")
    public void theSystemShouldDisplayAnErrorIndicatingClientNotFound() {
        System.out.println("Error: Client not found.");
    }
}
