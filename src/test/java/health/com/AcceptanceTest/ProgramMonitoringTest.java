package health.com.AcceptanceTest;

import health.com.ProgramMonitoring;
import health.com.Program;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramMonitoringTest {
    private Program mostPopularProgram;

    @Given("there are multiple programs")
    public void thereAreMultiplePrograms() {
        System.out.println("Programs initialized.");
        ProgramMonitoring.listPrograms();
    }

    @When("the admin views all programs")
    public void theAdminViewsAllPrograms() {
        ProgramMonitoring.listPrograms();
    }

    @Then("the system should display a list of all programs")
    public void theSystemShouldDisplayAListOfAllPrograms() {
        System.out.println("Displaying all programs:");
        ProgramMonitoring.listPrograms();
    }

    @When("the admin views the most popular program")
    public void theAdminViewsTheMostPopularProgram() {
        mostPopularProgram = ProgramMonitoring.getMostPopularProgram();
    }

    @Then("the system should display the program with the highest enrollments")
    public void theSystemShouldDisplayTheProgramWithTheHighestEnrollments() {
        if (mostPopularProgram != null) {
            System.out.println("Most Popular Program: " + mostPopularProgram.getTitle() +
                    " with " + mostPopularProgram.getEnrollments() + " enrollments.");
        }
    }

    @Given("the admin wants to add a new program")
    public void theAdminWantsToAddANewProgram() {
        System.out.println("Admin is ready to add a new program.");
    }

    @When("the admin adds a program with title {string}, enrollments {string}, and attendance {string}")
    public void theAdminAddsAProgramWithTitleEnrollmentsAndAttendance(String title, String enrollments, String attendance) {
        int enrollmentsInt = Integer.parseInt(enrollments);
        int attendanceInt = Integer.parseInt(attendance);
        ProgramMonitoring.addProgram(title, enrollmentsInt, attendanceInt);
    }

    @Then("the program should be added to the list")
    public void theProgramShouldBeAddedToTheList() {
        System.out.println("Updated Program List:");
        ProgramMonitoring.listPrograms();
    }
}
