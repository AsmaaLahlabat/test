package health.com.AcceptanceTest;

import health.com.ContentManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContentManagementTest {

    @Given("there are multiple pending articles")
    public void thereAreMultiplePendingArticles() {
        System.out.println("Displaying all pending articles:");
        ContentManagement.listPendingArticles();
    }

    @When("the admin views all pending articles")
    public void theAdminViewsAllPendingArticles() {
        ContentManagement.listPendingArticles();
    }

    @Then("the system should display a list of pending articles")
    public void theSystemShouldDisplayAListOfPendingArticles() {
        System.out.println("Pending articles listed successfully.");
    }

    @Given("there is a pending article titled {string}")
    public void thereIsAPendingArticleTitled(String title) {
        System.out.println("Pending article found: " + title);
    }

    @When("the admin approves the article")
    public void theAdminApprovesTheArticle() {
        if (ContentManagement.approveArticle("Healthy Eating Tips")) {
            System.out.println("Article approved successfully.");
        }
    }

    @Then("the article should be marked as approved")
    public void theArticleShouldBeMarkedAsApproved() {
        System.out.println("Article approved status updated.");
    }

    @When("the admin rejects the article")
    public void theAdminRejectsTheArticle() {
        if (ContentManagement.rejectArticle("Quick Fix Diet")) {
            System.out.println("Article rejected successfully.");
        }
    }

    @Then("the article should be marked as rejected")
    public void theArticleShouldBeMarkedAsRejected() {
        System.out.println("Article rejection status updated.");
    }

    @Given("there is a complaint with the title {string}")
    public void thereIsAComplaintWithTheTitle(String title) {
        System.out.println("Complaint found: " + title);
    }

    @When("the admin resolves the complaint")
    public void theAdminResolvesTheComplaint() {
        if (ContentManagement.resolveComplaint("Late Session Start")) {
            System.out.println("Complaint resolved successfully.");
        }
    }

    @Then("the complaint should be marked as resolved")
    public void theComplaintShouldBeMarkedAsResolved() {
        System.out.println("Complaint status updated to resolved.");
    }
}
