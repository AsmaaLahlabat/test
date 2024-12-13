package health.com;

import java.util.ArrayList;
import java.util.List;

public class ProgramMonitoring {
    private static final List<Program> programs = new ArrayList<>();

    static {
        programs.add(new Program("Yoga Basics", 50, 40));
        programs.add(new Program("Build Muscle", 100, 90));
    }

    public static void listPrograms() {
        if (programs.isEmpty()) {
            System.out.println("No programs available.");
        } else {
            programs.forEach(program -> System.out.println(program));
        }
    }

    public static Program getMostPopularProgram() {
        return programs.stream()
                .max((p1, p2) -> Integer.compare(p1.getEnrollments(), p2.getEnrollments()))
                .orElse(null);
    }

    public static void addProgram(String title, int enrollments, int attendance) {
        programs.add(new Program(title, enrollments, attendance));
        System.out.println("Program added successfully!");
    }

    public static boolean deleteProgram(String title) {
        return programs.removeIf(program -> program.getTitle().equalsIgnoreCase(title));
    }

    public static boolean updateProgram(String title, int newEnrollments, int newAttendance) {
        for (Program program : programs) {
            if (program.getTitle().equalsIgnoreCase(title)) {
                program.setEnrollments(newEnrollments);
                program.setAttendance(newAttendance);
                return true;
            }
        }
        return false;
    }
}
