package health.com;

import java.util.ArrayList;
import java.util.List;

public class InstructorManagement {
    private static final List<instructor_program> programs = new ArrayList<>();

    static {
        programs.add(new instructor_program("Yoga Basics", "2 Weeks", "Beginner", "Flexibility", 30, "Video"));
    }

    public static void addProgram(String title, String duration, String level, String goals, int price, String materials) {
        programs.add(new instructor_program(title, duration, level, goals, price, materials));
        System.out.println("Program added: " + title);
    }

    public static boolean updateProgram(String title, String newDuration, String newLevel, String newGoals, int newPrice, String newMaterials) {
        for (instructor_program program : programs) {
            if (program.getTitle().equalsIgnoreCase(title)) {
                program.setDuration(newDuration);
                program.setLevel(newLevel);
                program.setGoals(newGoals);
                program.setPrice(newPrice);
                program.setMaterials(newMaterials);
                System.out.println("Program updated: " + title);
                return true;
            }
        }
        System.out.println("Program not found: " + title);
        return false;
    }

    public static boolean deleteProgram(String title) {
        return programs.removeIf(program -> program.getTitle().equalsIgnoreCase(title));
    }

    public static void listPrograms() {
        if (programs.isEmpty()) {
            System.out.println("No programs available.");
        } else {
            System.out.println("Available Programs:");
            for (instructor_program program : programs) {
                System.out.println(program);
            }
        }
    }
}
