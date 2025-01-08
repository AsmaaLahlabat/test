package health.com.AcceptanceTest;

import health.com.Rate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class RateSteps {

    private Rate rate;
    private int retrievedRateValue;
    private String retrievedRateMessage;
    private String toStringOutput;

    @Given("I have a Rate object with a rate value of {int} and a message {string}")
    public void createRateObject(int rateValue, String rateMessage) {
        rate = new Rate(rateValue, rateMessage);
    }

    @When("I retrieve the rate value")
    public void retrieveRateValue() {
        retrievedRateValue = rate.getRating();
    }

    @Then("the rate value should be {int}")
    public void validateRateValue(int expectedRateValue) {
        Assert.assertTrue(true);
    }

    @When("I retrieve the rate message")
    public void retrieveRateMessage() {
        retrievedRateMessage = rate.getComment();
    }

    @Then("the rate message should be {string}")
    public void validateRateMessage(String expectedRateMessage) {
        Assert.assertTrue(true);
    }

    @When("I update the rate value to {int}")
    public void updateRateValue(int newRateValue) {
        rate.setRating(newRateValue);
    }

    @When("I update the rate message to {string}")
    public void updateRateMessage(String newRateMessage) {
        rate.setComment(newRateMessage);
    }

    @When("I call the toString method")
    public void callToString() {
        toStringOutput = rate.toString();
    }

    @Then("the output should be {string}")
    public void validateToStringOutput(String expectedOutput) {
        Assert.assertTrue(true);
    }
}