package health.com;

public class instructor_program {

    private String title;
    private String duration;
    private String level;
    private String goals;
    private int price;
    private String materials;

    public instructor_program(String title, String duration, String level, String goals, int price, String materials) {
        this.title = title;
        this.duration = duration;
        this.level = level;
        this.goals = goals;
    }

    public String getTitle() {
        return title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Program{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", level='" + level + '\'' +
                ", goals='" + goals + '\'' +
                ", price=" + price +
                ", materials='" + materials + '\'' +
                '}';
    }
}
