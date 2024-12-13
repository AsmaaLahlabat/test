package health.com;

public class Complaint {
    private final String title;
    private String status;

    public Complaint(String title, String status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
