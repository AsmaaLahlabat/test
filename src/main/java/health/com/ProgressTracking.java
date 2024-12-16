package health.com;

import java.util.ArrayList;
import java.util.List;

public class ProgressTracking {
    private static final List<String> progressReports = new ArrayList<>();
    private static final List<String> reminders = new ArrayList<>();
    private static final List<String> clients = new ArrayList<>();

    static {
        // بيانات أولية
        progressReports.add("Client1: Completed 70%, Attendance: 90%");
        progressReports.add("Client2: Completed 50%, Attendance: 80%");
        clients.add("Client1");
        clients.add("Client2");
    }

    public static void listProgressReports() {
        System.out.println("\n==== Client Progress Reports ====");
        if (progressReports.isEmpty()) {
            System.out.println("No progress reports available.");
        } else {
            for (String report : progressReports) {
                System.out.println(report);
            }
        }
    }

    public static void sendMotivationalReminder(String clientName, String message) {
        if (clients.contains(clientName)) {
            String reminder = "To " + clientName + ": " + message;
            reminders.add(reminder);
            System.out.println("Motivational Reminder Sent: " + reminder);
        } else {
            System.out.println("Error: Client '" + clientName + "' not found.");
        }
    }

    public static void clearProgressReports() {
        progressReports.clear();
    }

    public static List<String> getReminders() {
        return reminders;
    }
}
