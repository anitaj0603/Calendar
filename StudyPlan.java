public class StudyPlan implements Comparable<StudyPlan> {
    private String course;
    private String task;
    private String dueDate;  
    public StudyPlan(String course, String task, String dueDate) {
        this.course = course;
        this.task = task;
        this.dueDate = dueDate;
    }

    public int compareTo(StudyPlan other) {
        return this.dueDate.compareTo(other.dueDate);
    }

    public String toString() {
        return "Course: " + course + 
               "\nTask: " + task +
               "\nDue: " + dueDate;
    }

    public String getDueDate() { return dueDate; }
    public String getTask() { return task; }
}
