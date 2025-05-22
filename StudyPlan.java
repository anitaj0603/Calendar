public class StudyPlan {
    private String course;
    private String task;
    private String dueDate;

    public StudyPlan(String course, String task, String dueDate) {
        this.course = course;
        this.task = task;
        this.dueDate = dueDate;
    }

    public String toString() {
        return "Course: " + course + 
               "\nTask: " + task +
               "\nDue: " + dueDate;
    }
}
