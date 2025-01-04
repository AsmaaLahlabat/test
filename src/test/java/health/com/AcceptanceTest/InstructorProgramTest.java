package health.com.AcceptanceTest;

import health.com.InstructorManagement;
import health.com.instructor_program;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        Assert.assertTrue("The program should exist after addition",
                InstructorManagement.programs.stream()
                        .anyMatch(program -> program.getTitle().equalsIgnoreCase("Strength Training")));
    }

    @When("the instructor updates the program {string} with duration {string}, level {string}, goals {string}, price {string}, and materials {string}")
    public void theInstructorUpdatesTheProgram(String title, String duration, String level, String goals, String price, String materials) {
        int programPrice = Integer.parseInt(price);
        boolean isUpdated = InstructorManagement.updateProgram(title, duration, level, goals, programPrice, materials);
        Assert.assertTrue("The program should be updated successfully", isUpdated);
    }

    @Then("the program should be updated successfully")
    public void theProgramShouldBeUpdatedSuccessfully() {
        instructor_program updatedProgram = InstructorManagement.programs.stream()
                .filter(program -> program.getTitle().equalsIgnoreCase("Yoga Basics"))
                .findFirst()
                .orElse(null);
        Assert.assertNotNull("The updated program should exist", updatedProgram);
        Assert.assertEquals("Updated level should match", "Intermediate", updatedProgram.getLevel());
    }

    @When("the instructor deletes the program {string}")
    public void theInstructorDeletesTheProgram(String title) {
        boolean existsBeforeDelete = InstructorManagement.programs.stream()
                .anyMatch(program -> program.getTitle().equalsIgnoreCase(title));
        Assert.assertTrue("The program should exist before deletion", existsBeforeDelete);

        boolean isDeleted = InstructorManagement.deleteProgram(title);
        Assert.assertTrue("The program should be deleted successfully", isDeleted);
    }

    @Then("the program should be deleted successfully")
    public void theProgramShouldBeDeletedSuccessfully() {
        boolean existsAfterDelete = InstructorManagement.programs.stream()
                .anyMatch(program -> program.getTitle().equalsIgnoreCase("HIIT Workout"));
        Assert.assertFalse("The program should not exist after deletion", existsAfterDelete);
    }
}
