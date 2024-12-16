package health.com;

public class Notification {
    private String message;
    private String target; // ALL_CLIENTS or specific program name

    public Notification(String message, String target) {
        this.message = message;
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTarget() {
        return target;
    }
}
