package health.com.AcceptanceTest;

import health.com.UserManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementTest {

    @Given("the admin is on the user management page")
    public void theAdminIsOnTheUserManagementPage() {
        System.out.println("Admin navigates to the user management page.");
    }

    @When("the admin adds a new user with username {string}, password {string}, and role {string}")
    public void theAdminAddsANewUserWithUsernamePasswordAndRole(String username, String password, String role) {
        UserManagement.addUser(username, password, role);
    }

    @Then("the user should be added successfully")
    public void theUserShouldBeAddedSuccessfully() {
        System.out.println("User added successfully!");
    }

    @When("the admin updates the user {string} with new password {string} and role {string}")
    public void theAdminUpdatesTheUserWithNewPasswordAndRole(String username, String newPassword, String newRole) {
        UserManagement.updateUser(username, newPassword, newRole);
    }

    @Then("the user details should be updated successfully")
    public void theUserDetailsShouldBeUpdatedSuccessfully() {
        System.out.println("User updated successfully!");
    }

    @When("the admin deactivates the user {string}")
    public void theAdminDeactivatesTheUser(String username) {
        UserManagement.deactivateUser(username);
    }

    @Then("the user should be deactivated successfully")
    public void theUserShouldBeDeactivatedSuccessfully() {
        System.out.println("User deactivated successfully!");
    }

    @Given("there are pending instructor registrations")
    public void thereArePendingInstructorRegistrations() {
        System.out.println("Pending instructor registrations available.");
    }

    @When("the admin approves the registration for {string}")
    public void theAdminApprovesTheRegistrationFor(String username) {
        UserManagement.approveRegistration(username);
    }

    @Then("the instructor should be approved successfully")
    public void theInstructorShouldBeApprovedSuccessfully() {
        System.out.println("Instructor registration approved successfully!");
    }

    @Given("there are multiple users")
    public void thereAreMultipleUsers() {
        System.out.println("Users are available in the system.");
    }

    @When("the admin monitors user activities")
    public void theAdminMonitorsUserActivities() {
        UserManagement.monitorActivities();
    }

    @Then("the system should display user activity statistics")
    public void theSystemShouldDisplayUserActivityStatistics() {
        System.out.println("Displaying user activity statistics.");
    }
}
