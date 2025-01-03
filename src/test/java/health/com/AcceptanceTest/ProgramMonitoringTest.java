package health.com.AcceptanceTest;

import health.com.ProgramMonitoring;
import health.com.Program;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class ProgramMonitoringTest {
    private Program mostPopularProgram;

    @Given("there are multiple programs")
    public void thereAreMultiplePrograms() {
        assertFalse("No programs available.", ProgramMonitoring.getPrograms().isEmpty());
        System.out.println("Programs initialized.");
        ProgramMonitoring.listPrograms();
    }

    @When("the admin views all programs")
    public void theAdminViewsAllPrograms() {
        assertFalse("No programs available.", ProgramMonitoring.getPrograms().isEmpty());
        ProgramMonitoring.listPrograms();
    }

    @Then("the system should display a list of all programs")
    public void theSystemShouldDisplayAListOfAllPrograms() {
        assertFalse("No programs available.", ProgramMonitoring.getPrograms().isEmpty());
        System.out.println("Displaying all programs:");
        ProgramMonitoring.listPrograms();
    }

    @When("the admin views the most popular program")
    public void theAdminViewsTheMostPopularProgram() {
        mostPopularProgram = ProgramMonitoring.getMostPopularProgram();
        assertNotNull("Most popular program is null.", mostPopularProgram);
    }

    @Then("the system should display the program with the highest enrollments")
    public void theSystemShouldDisplayTheProgramWithTheHighestEnrollments() {
        assertNotNull("Most popular program is null.", mostPopularProgram);
        System.out.println("Most Popular Program: " + mostPopularProgram.getTitle() +
                " with " + mostPopularProgram.getEnrollments() + " enrollments.");
    }

    @Given("the admin wants to add a new program")
    public void theAdminWantsToAddANewProgram() {
        System.out.println("Admin is ready to add a new program.");
    }

    @When("the admin adds a program with title {string}, enrollments {string}, and attendance {string}")
    public void theAdminAddsAProgramWithTitleEnrollmentsAndAttendance(String title, String enrollments, String attendance) {
        int enrollmentsInt = Integer.parseInt(enrollments);
        int attendanceInt = Integer.parseInt(attendance);
        int initialSize = ProgramMonitoring.getPrograms().size();
        ProgramMonitoring.addProgram(title, enrollmentsInt, attendanceInt,"hard","leg");
        assertEquals("Program was not added.", initialSize + 1, ProgramMonitoring.getPrograms().size());
    }

    @Then("the program should be added to the list")
    public void theProgramShouldBeAddedToTheList() {
        System.out.println("Updated Program List:");
        ProgramMonitoring.listPrograms();
    }
}
