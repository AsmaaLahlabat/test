package health.com.AcceptanceTest;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class Program {
    private String title;
    private int enrollments;
    private int attendance;

    public Program(String title, int enrollments, int attendance) {
        this.title = title;
        this.enrollments = enrollments;
        this.attendance = attendance;
    }

    public String getTitle() {
        return title;
    }

    public int getEnrollments() {
        return enrollments;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEnrollments(int enrollments) {
        this.enrollments = enrollments;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Program{" +
                "title='" + title + '\'' +
                ", enrollments=" + enrollments +
                ", attendance=" + attendance +
                '}';
    }
}

public class feature2 {
    private List<Program> programs = new ArrayList<>();
    private Program mostPopularProgram;
    private List<String> attendanceReport = new ArrayList<>();

    @Given("there are multiple programs")
    public void thereAreMultiplePrograms() {
        programs.add(new Program("Yoga Basics", 50, 45));
        programs.add(new Program("Weightlifting 101", 75, 60));
        programs.add(new Program("Cardio Blast", 30, 25));
        System.out.println("Programs initialized.");
    }

    @When("the admin views the most popular program")
    public void theAdminViewsTheMostPopularProgram() {
        mostPopularProgram = programs.stream()
                .max((p1, p2) -> Integer.compare(p1.getEnrollments(), p2.getEnrollments()))
                .orElse(null);
    }

    @Then("the system should display the program with the highest enrollments")
    public void theSystemShouldDisplayTheProgramWithTheHighestEnrollments() {
        if (mostPopularProgram != null) {
            System.out.println("Most Popular Program: " + mostPopularProgram.getTitle() +
                    " with " + mostPopularProgram.getEnrollments() + " enrollments.");
        } else {
            System.out.println("No programs available.");
        }
    }

    @When("the admin generates an attendance report")
    public void theAdminGeneratesAnAttendanceReport() {
        attendanceReport.clear();
        for (Program program : programs) {
            attendanceReport.add("Program: " + program.getTitle() + ", Attendance: " + program.getAttendance());
        }
    }

    @Then("the system should display a report with program names and attendance")
    public void theSystemShouldDisplayAReportWithProgramNamesAndAttendance() {
        System.out.println("Attendance Report:");
        for (String report : attendanceReport) {
            System.out.println(report);
        }
    }

    @When("the admin views all programs")
    public void theAdminViewsAllPrograms() {
        System.out.println("List of All Programs:");
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    @Then("the system should display a list of all programs")
    public void theSystemShouldDisplayAListOfAllPrograms() {
        System.out.println("List of All Programs:");
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    @Given("the admin wants to add a new program")
    public void theAdminWantsToAddANewProgram() {
        System.out.println("Admin is preparing to add a new program.");
    }

    @When("the admin adds a program with title {string}, enrollments {string}, and attendance {string}")
    public void theAdminAddsAProgramWithTitleEnrollmentsAndAttendance(String title, String enrollments, String attendance) {
        int enrollmentsInt = Integer.parseInt(enrollments);
        int attendanceInt = Integer.parseInt(attendance);
        programs.add(new Program(title, enrollmentsInt, attendanceInt));
        System.out.println("Program added: " + title);
    }

    @Then("the program should be added to the list")
    public void theProgramShouldBeAddedToTheList() {
        System.out.println("Current Programs:");
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    @When("the admin edits the program with title {string} to have new title {string}, enrollments {string}, and attendance {string}")
    public void theAdminEditsTheProgram(String oldTitle, String newTitle, String newEnrollments, String newAttendance) {
        for (Program program : programs) {
            if (program.getTitle().equals(oldTitle)) {
                program.setTitle(newTitle);
                program.setEnrollments(Integer.parseInt(newEnrollments));
                program.setAttendance(Integer.parseInt(newAttendance));
                System.out.println("Program updated successfully.");
                return;
            }
        }
        System.out.println("Program not found: " + oldTitle);
    }

    @Then("the program should be updated in the list")
    public void theProgramShouldBeUpdatedInTheList() {
        System.out.println("Updated Programs:");
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    @When("the admin deletes the program with title {string}")
    public void theAdminDeletesTheProgramWithTitle(String title) {
        programs.removeIf(program -> program.getTitle().equals(title));
        System.out.println("Program deleted: " + title);
    }

    @Then("the program should no longer exist in the list")
    public void theProgramShouldNoLongerExistInTheList() {
        System.out.println("Current Programs After Deletion:");
        for (Program program : programs) {
            System.out.println(program);
        }
    }
}
