package health.com;

public class Article {
    private String title;
    private String status;

    public Article(String title, String status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
