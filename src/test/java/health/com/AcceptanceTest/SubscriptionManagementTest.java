package health.com.AcceptanceTest;

import health.com.SubscriptionManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionManagementTest {
    @Given("the admin is on the subscription management page")
    public void theAdminIsOnTheSubscriptionManagementPage() {
        System.out.println("Admin navigates to the subscription management page.");
        SubscriptionManagement.listPlans();
    }

    @When("the admin adds a new subscription plan {string} with price {string}")
    public void theAdminAddsANewSubscriptionPlanWithPrice(String name, String price) {
        int priceInt = Integer.parseInt(price);
        SubscriptionManagement.addSubscriptionPlan(name, priceInt);
    }

    @Then("the subscription plan should be added successfully")
    public void theSubscriptionPlanShouldBeAddedSuccessfully() {
        System.out.println("Updated Subscription Plans:");
        SubscriptionManagement.listPlans();
    }

    @When("the admin updates the plan {string} with new price {string}")
    public void theAdminUpdatesThePlanWithNewPrice(String name, String newPrice) {
        int newPriceInt = Integer.parseInt(newPrice);
        boolean isUpdated = SubscriptionManagement.updateSubscriptionPlan(name, newPriceInt);
        if (isUpdated) {
            System.out.println("Plan updated successfully: " + name);
        } else {
            System.out.println("Failed to update plan: " + name);
        }
    }

    @Then("the subscription plan should be updated successfully")
    public void theSubscriptionPlanShouldBeUpdatedSuccessfully() {
        System.out.println("Updated Subscription Plans:");
        SubscriptionManagement.listPlans();
    }

    @When("the admin deletes the plan {string}")
    public void theAdminDeletesThePlan(String name) {
        boolean isDeleted = SubscriptionManagement.deleteSubscriptionPlan(name);
        if (isDeleted) {
            System.out.println("Plan deleted successfully: " + name);
        } else {
            System.out.println("Failed to delete plan: " + name);
        }
    }

    @Then("the subscription plan should be deleted successfully")
    public void theSubscriptionPlanShouldBeDeletedSuccessfully() {
        System.out.println("Updated Subscription Plans:");
        SubscriptionManagement.listPlans();
    }
}
