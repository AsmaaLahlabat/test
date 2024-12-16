package health.com;

import java.util.ArrayList;
import java.util.List;

public class ClientCommunication {
    private static final List<Notification> notifications = new ArrayList<>();

    public static void sendMessage(String target, String message) {
        notifications.add(new Notification(message, target));
        System.out.println("Message sent to: " + (target.equalsIgnoreCase("ALL_CLIENTS") ? "All Clients" : "Clients of " + target));
    }

    public static List<String> getAllMessages() {
        List<String> messageList = new ArrayList<>();
        for (Notification notification : notifications) {
            messageList.add("To: " + notification.getTarget() + " | Message: " + notification.getMessage());
        }
        return messageList;
    }


    public static void viewNotifications() {
        if (notifications.isEmpty()) {
            System.out.println("No notifications have been sent yet.");
            return;
        }

        System.out.println("\n==== Sent Notifications ====");
        for (int i = 0; i < notifications.size(); i++) {
            System.out.println((i + 1) + ". To: " + notifications.get(i).getTarget() + " | Message: " + notifications.get(i).getMessage());
        }
    }

    public static void editNotification(int index, String newMessage) {
        if (index >= 0 && index < notifications.size()) {
            notifications.get(index).setMessage(newMessage);
            System.out.println("Notification updated successfully.");
        } else {
            System.out.println("Invalid notification index.");
        }
    }

    public static void deleteNotification(int index) {
        if (index >= 0 && index < notifications.size()) {
            notifications.remove(index);
            System.out.println("Notification deleted successfully.");
        } else {
            System.out.println("Invalid notification index.");
        }
    }
}
