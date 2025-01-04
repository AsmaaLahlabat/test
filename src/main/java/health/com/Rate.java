package health.com;

public class Rate {
    private int rating;
    private String comment;

    public Rate(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
