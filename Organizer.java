import java.util.ArrayList;
import java.util.Scanner;

public class Organizer {
    private ArrayList<Event> events;
    private ArrayList<StudyPlan> studyPlans;
    private Scanner scanner;

    public Organizer() {
        events = new ArrayList<>();
        studyPlans = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Student Organizer");
        
        while (true) {
            System.out.println("\n1. Add Event");
            System.out.println("2. Add Study Plan");
            System.out.println("3. View Events");
            System.out.println("4. View Study Plans");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    addStudyPlan();
                    break;
                case 3:
                    viewEvents();
                    break;
                case 4:
                    viewStudyPlans();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addEvent() {
        System.out.println("\nAdd New Event");
        System.out.print("Event name: ");
        String name = scanner.nextLine();
        
        System.out.print("Date (MM/DD/YYYY): ");
        String date = scanner.nextLine();
        
        System.out.print("Start time: ");
        String start = scanner.nextLine();
        
        System.out.print("End time: ");
        String end = scanner.nextLine();
        
        System.out.print("Additional info: ");
        String info = scanner.nextLine();
        
        events.add(new Event(name, date, start, end, info));
        System.out.println("Event added!");
    }

    private void addStudyPlan() {
        System.out.println("\nAdd Study Plan");
        System.out.print("Course: ");
        String course = scanner.nextLine();
        
        System.out.print("Task: ");
        String task = scanner.nextLine();
        
        System.out.print("Due date: ");
        String due = scanner.nextLine();
        
        studyPlans.add(new StudyPlan(course, task, due));
        System.out.println("Study plan added!");
    }

    private void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }
        
        System.out.println("\nYour Events:");
        for (Event e : events) {
            System.out.println("\n" + e);
        }
    }

    private void viewStudyPlans() {
        if (studyPlans.isEmpty()) {
            System.out.println("No study plans found.");
            return;
        }
        
        System.out.println("\nYour Study Plans:");
        for (StudyPlan s : studyPlans) {
            System.out.println("\n" + s);
        }
    }
}
