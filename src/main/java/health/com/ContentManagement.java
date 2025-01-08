package health.com;

import java.util.ArrayList;
import java.util.List;

public class ContentManagement {

    private static final List<Article> pendingArticles = new ArrayList<>();
    private static final List<Complaint> complaints = new ArrayList<>();


    static {
        pendingArticles.add(new Article("Healthy Eating Tips", "Pending"));
        pendingArticles.add(new Article("Quick Fix Diet", "Pending"));
        complaints.add(new Complaint("Late Session Start", "Pending"));
        complaints.add(new Complaint("Missing Diet Plan Info", "Pending"));
    }

    public static List<Article> getPendingArticles() {
        return pendingArticles;
    }

    public static List<Complaint> getComplaints() {
        return complaints;
    }

    public static void listPendingArticles() {
        if (pendingArticles.isEmpty()) {
            System.out.println("No pending articles available.");
        } else {
            System.out.println("\nPending Articles:");
            pendingArticles.forEach(article -> System.out.println(article));
        }
    }

    public static boolean approveArticle(String title) {
        for (Article article : pendingArticles) {
            if (article.getTitle().equalsIgnoreCase(title)) {
                article.setStatus("Approved");
                return true;
            }
        }
        return false;
    }

    public static boolean rejectArticle(String title) {
        for (Article article : pendingArticles) {
            if (article.getTitle().equalsIgnoreCase(title)) {
                article.setStatus("Rejected");
                return true;
            }
        }
        return false;
    }

    public static void listComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints available.");
        } else {
            System.out.println("\nUser Complaints:");
            complaints.forEach(complaint -> System.out.println(complaint));
        }
    }

    public static boolean resolveComplaint(String title) {
        for (Complaint complaint : complaints) {
            if (complaint.getTitle().equalsIgnoreCase(title)) {
                complaint.setStatus("Resolved");
                return true;
            }
        }
        return false;
    }
}
