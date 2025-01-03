package health.com;

public class Program {
    private String title;
    private int enrollments;
    private int attendance;

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    private String difficultyLevel;

    public String getFoucs() {
        return foucs;
    }

    public void setFoucs(String foucs) {
        this.foucs = foucs;
    }

    private String foucs;
    public Program(String title, int enrollments, int attendance,String difficultyLevel,String foucs) {
        this.title = title;
        this.enrollments = enrollments;
        this.attendance = attendance;
        this.difficultyLevel=difficultyLevel;
        this.foucs=foucs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(int enrollments) {
        this.enrollments = enrollments;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Program{" +
                "title='" + title + '\'' +
                ", enrollments=" + enrollments +
                ", attendance=" + attendance +
                '}';
    }
}
