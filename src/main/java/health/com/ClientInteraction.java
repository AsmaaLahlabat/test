package health.com;

import java.util.HashMap;
import java.util.Map;

public class ClientInteraction {
    private static final Map<String, String> clientMessages = new HashMap<>();
    private static final Map<String, String> progressReports = new HashMap<>();

    public static void sendMessage(String clientName, String message) {
        clientMessages.put(clientName, message);
        System.out.println("Message to " + clientName + ": " + message);
    }

    public static void provideProgressReport(String clientName, String report) {
        progressReports.put(clientName, report);
        System.out.println("Progress report for " + clientName + ": " + report);
    }

    public static void listClientMessages() {
        System.out.println("\nAll Client Messages:");
        clientMessages.forEach((client, message) ->
                System.out.println("Client: " + client + " -> Message: " + message));
    }

    public static void listProgressReports() {
        System.out.println("\nAll Progress Reports:");
        progressReports.forEach((client, report) ->
                System.out.println("Client: " + client + " -> Report: " + report));
    }
}
