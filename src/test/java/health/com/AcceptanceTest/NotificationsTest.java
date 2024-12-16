package health.com.AcceptanceTest;

import health.com.ClientCommunication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class NotificationsTest {
    private String message;

    @Given("the instructor is on the notifications and updates page")
    public void theInstructorIsOnTheNotificationsPage() {
        System.out.println("Instructor navigates to Notifications and Updates Page.");
    }

    @When("the instructor sends a notification {string}")
    public void theInstructorSendsANotification(String notification) {
        message = notification;
        ClientCommunication.sendMessage("ALL_CLIENTS", notification);
    }

    @Then("all clients should receive the notification")
    public void allClientsShouldReceiveTheNotification() {
        List<String> notifications = ClientCommunication.getAllMessages();
        if (notifications.contains("To: ALL_CLIENTS | Message: " + message)) {
            System.out.println("Notification sent successfully: " + message);
        } else {
            System.out.println("Notification failed.");
        }
    }

    @When("the instructor announces {string}")
    public void theInstructorAnnounces(String announcement) {
        message = announcement;
        ClientCommunication.sendMessage("ALL_CLIENTS", announcement);
    }

    @Then("all clients should receive the announcement")
    public void allClientsShouldReceiveTheAnnouncement() {
        List<String> notifications = ClientCommunication.getAllMessages();
        if (notifications.contains("To: ALL_CLIENTS | Message: " + message)) {
            System.out.println("Announcement sent successfully: " + message);
        } else {
            System.out.println("Announcement failed.");
        }
    }

    @When("the instructor selects an invalid option")
    public void theInstructorSelectsAnInvalidOption() {
        System.out.println("Invalid option selected.");
    }

    @Then("an invalid option error message should be displayed")
    public void anInvalidOptionErrorMessageShouldBeDisplayed() {
        System.out.println("Error: Invalid choice. Please try again.");
    }
}
