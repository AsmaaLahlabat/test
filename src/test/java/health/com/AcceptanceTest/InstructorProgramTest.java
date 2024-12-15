package health.com.AcceptanceTest;

import health.com.InstructorManagement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstructorProgramTest {

    @Given("the instructor is on the program management page")
    public void theInstructorIsOnTheProgramManagementPage() {
        System.out.println("Instructor navigates to Program Management Page.");
    }

    @When("the instructor adds a program with title {string}, duration {string}, level {string}, goals {string}, price {string}, and materials {string}")
    public void theInstructorAddsAProgram(String title, String duration, String level, String goals, String price, String materials) {
        int programPrice = Integer.parseInt(price);
        InstructorManagement.addProgram(title, duration, level, goals, programPrice, materials);
    }

    @Then("the program should be added successfully")
    public void theProgramShouldBeAddedSuccessfully() {
        System.out.println("Verifying program addition...");
        InstructorManagement.listPrograms();
    }

    @When("the instructor updates the program {string} with duration {string}, level {string}, goals {string}, price {string}, and materials {string}")
    public void theInstructorUpdatesTheProgram(String title, String duration, String level, String goals, String price, String materials) {
        int programPrice = Integer.parseInt(price);
        InstructorManagement.updateProgram(title, duration, level, goals, programPrice, materials);
    }

    @Then("the program should be updated successfully")
    public void theProgramShouldBeUpdatedSuccessfully() {
        System.out.println("Verifying program update...");
        InstructorManagement.listPrograms();
    }

    @When("the instructor deletes the program {string}")
    public void theInstructorDeletesTheProgram(String title) {
        InstructorManagement.deleteProgram(title);
    }

    @Then("the program should be deleted successfully")
    public void theProgramShouldBeDeletedSuccessfully() {
        System.out.println("Verifying program deletion...");
        InstructorManagement.listPrograms();
    }
}
