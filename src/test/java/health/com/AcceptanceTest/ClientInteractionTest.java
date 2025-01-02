package health.com.AcceptanceTest;

import health.com.ClientInteraction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//
import java.util.List;

public class ClientInteractionTest {
    private String clientName;
    private String message;
    private String progressReport;

    @Given("the instructor is on the client interaction page")
    public void theInstructorIsOnTheClientInteractionPage() {
        System.out.println("Instructor navigates to the Client Interaction Page.");
    }

    @When("the instructor sends a message {string} to the client {string}")
    public void theInstructorSendsAMessageToTheClient(String message, String clientName) {
        this.clientName = clientName;
        this.message = message;
        ClientInteraction.sendMessage(clientName, message);
    }

    @When("the instructor sends a message {string} to the following clients:")
    public void theInstructorSendsAMessageToMultipleClients(String message, List<String> clients) {
        this.message = message;
        clients.forEach(client -> ClientInteraction.sendMessage(client, message));
    }

    @Then("the message should be sent successfully")
    public void theMessageShouldBeSentSuccessfully() {
        System.out.println("Message sent to " + clientName + ": " + message);
    }

    @Then("the message should be sent to all clients successfully")
    public void theMessageShouldBeSentToAllClientsSuccessfully() {
        System.out.println("Message sent to all selected clients: " + message);
    }

    @When("the instructor provides a progress report {string} to the client {string}")
    public void theInstructorProvidesAProgressReportToTheClient(String progressReport, String clientName) {
        this.clientName = clientName;
        this.progressReport = progressReport;
        ClientInteraction.provideProgressReport(clientName, progressReport);
    }

    @Then("the progress report should be provided successfully")
    public void theProgressReportShouldBeProvidedSuccessfully() {
        System.out.println("Progress report sent to " + clientName + ": " + progressReport);
    }

    @Given("the instructor has sent multiple messages")
    public void theInstructorHasSentMultipleMessages() {
        ClientInteraction.sendMessage("ali", "Keep going!");
        ClientInteraction.sendMessage("ahmad", "Great progress!");
    }

    @When("the instructor views all messages")
    public void theInstructorViewsAllMessages() {
        ClientInteraction.listClientMessages();
    }

    @Then("all messages should be displayed")
    public void allMessagesShouldBeDisplayed() {
        System.out.println("All client messages displayed successfully.");
    }

    @Given("the instructor has provided multiple progress reports")
    public void theInstructorHasProvidedMultipleProgressReports() {
        ClientInteraction.provideProgressReport("ali", "Completion: 80%, Attendance: 85%");
        ClientInteraction.provideProgressReport("ahmad", "Completion: 60%, Attendance: 70%");
    }

    @When("the instructor views all progress reports")
    public void theInstructorViewsAllProgressReports() {
        ClientInteraction.listProgressReports();
    }

    @Then("all progress reports should be displayed")
    public void allProgressReportsShouldBeDisplayed() {
        System.out.println("All progress reports displayed successfully.");
    }
}
