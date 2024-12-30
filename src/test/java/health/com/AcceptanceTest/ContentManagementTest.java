package health.com.AcceptanceTest;

import health.com.ContentManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class ContentManagementTest {

    @Given("there are multiple pending articles")
    public void thereAreMultiplePendingArticles() {
        assertFalse("No pending articles available.", ContentManagement.getPendingArticles().isEmpty());
        System.out.println("Displaying all pending articles:");
        ContentManagement.listPendingArticles();
    }

    @When("the admin views all pending articles")
    public void theAdminViewsAllPendingArticles() {
        assertFalse("No pending articles available.", ContentManagement.getPendingArticles().isEmpty());
        ContentManagement.listPendingArticles();
    }

    @Then("the system should display a list of pending articles")
    public void theSystemShouldDisplayAListOfPendingArticles() {
        assertFalse("No pending articles available.", ContentManagement.getPendingArticles().isEmpty());
        System.out.println("Pending articles listed successfully.");
    }

    @Given("there is a pending article titled {string}")
    public void thereIsAPendingArticleTitled(String title) {
        assertTrue("Article not found: " + title, ContentManagement.getPendingArticles().stream().anyMatch(a -> a.getTitle().equalsIgnoreCase(title)));
        System.out.println("Pending article found: " + title);
    }

    @When("the admin approves the article")
    public void theAdminApprovesTheArticle() {
        boolean result = ContentManagement.approveArticle("Healthy Eating Tips");
        assertTrue("Failed to approve the article.", result);
        System.out.println("Article approved successfully.");
    }

    @Then("the article should be marked as approved")
    public void theArticleShouldBeMarkedAsApproved() {
        assertTrue("Article is not marked as approved.", ContentManagement.getPendingArticles().stream().anyMatch(a -> a.getTitle().equalsIgnoreCase("Healthy Eating Tips") && a.getStatus().equals("Approved")));
        System.out.println("Article approved status updated.");
    }

    @When("the admin rejects the article")
    public void theAdminRejectsTheArticle() {
        boolean result = ContentManagement.rejectArticle("Quick Fix Diet");
        assertTrue("Failed to reject the article.", result);
        System.out.println("Article rejected successfully.");
    }

    @Then("the article should be marked as rejected")
    public void theArticleShouldBeMarkedAsRejected() {
        assertTrue("Article is not marked as rejected.", ContentManagement.getPendingArticles().stream().anyMatch(a -> a.getTitle().equalsIgnoreCase("Quick Fix Diet") && a.getStatus().equals("Rejected")));
        System.out.println("Article rejection status updated.");
    }

    @Given("there is a complaint with the title {string}")
    public void thereIsAComplaintWithTheTitle(String title) {
        assertTrue("Complaint not found: " + title, ContentManagement.getComplaints().stream().anyMatch(c -> c.getTitle().equalsIgnoreCase(title)));
        System.out.println("Complaint found: " + title);
    }

    @When("the admin resolves the complaint")
    public void theAdminResolvesTheComplaint() {
        boolean result = ContentManagement.resolveComplaint("Late Session Start");
        assertTrue("Failed to resolve the complaint.", result);
        System.out.println("Complaint resolved successfully.");
    }

    @Then("the complaint should be marked as resolved")
    public void theComplaintShouldBeMarkedAsResolved() {
        assertTrue("Complaint is not marked as resolved.", ContentManagement.getComplaints().stream().anyMatch(c -> c.getTitle().equalsIgnoreCase("Late Session Start") && c.getStatus().equals("Resolved")));
        System.out.println("Complaint status updated to resolved.");
    }
}