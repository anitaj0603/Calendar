import java.util.ArrayList;
import java.util.Collections;
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
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add Event");
            System.out.println("2. Add Study Plan");
            System.out.println("3. View/Delete Events");
            System.out.println("4. View/Delete Study Plans");
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
                    manageEvents();
                    break;
                case 4:
                    manageStudyPlans();
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
        System.out.println("\nADD NEW EVENT");
        System.out.print("Event name: ");
        String name = scanner.nextLine();
        
        System.out.print("Date (MM/DD/YYYY): ");
        String date = scanner.nextLine();
        
        System.out.print("Start time (HH:mm, 24-hour format): ");
        String start = scanner.nextLine();
        
        System.out.print("End time (HH:mm, 24-hour format): ");
        String end = scanner.nextLine();
        
        if (!isValidTime(start) || !isValidTime(end)) {
            System.out.println("Invalid time format. Use HH:mm in 24-hour format.");
            return;
        }
        
        if (timeToMinutes(end) <= timeToMinutes(start)) {
            System.out.println("Error: End time must be after start time.");
            return;
        }
        
        System.out.print("Additional info: ");
        String info = scanner.nextLine();
        
        Event newEvent = new Event(name, date, start, end, info);
        
        for (Event existingEvent : events) {
            if (newEvent.overlapsWith(existingEvent)) {
                System.out.println("\nERROR: This event overlaps with:");
                System.out.println(existingEvent);
                System.out.println("Please choose a different time.");
                return;
            }
        }
        
        events.add(newEvent);
        Collections.sort(events);
        System.out.println("Event added!");
    }

    private void addStudyPlan() {
        System.out.println("\nADD STUDY PLAN");
        System.out.print("Course: ");
        String course = scanner.nextLine();
        
        System.out.print("Task: ");
        String task = scanner.nextLine();
        
        System.out.print("Due date (MM/DD/YYYY): ");
        String due = scanner.nextLine();
        
        studyPlans.add(new StudyPlan(course, task, due));
        Collections.sort(studyPlans);
        System.out.println("Study plan added!");
    }

    private void manageEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }
        
        System.out.println("\nYOUR EVENTS (sorted by date)");
        for (int i = 0; i < events.size(); i++) {
            System.out.println("\n[" + (i+1) + "] " + events.get(i));
        }
        
        System.out.print("\nEnter number to delete (0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice > 0 && choice <= events.size()) {
            Event removed = events.remove(choice-1);
            System.out.println("Deleted: " + removed.getName());
        } else if (choice != 0) {
            System.out.println("Invalid choice.");
        }
    }

    private void manageStudyPlans() {
        if (studyPlans.isEmpty()) {
            System.out.println("No study plans found.");
            return;
        }
        
        System.out.println("\nYOUR STUDY PLANS (sorted by due date)");
        for (int i = 0; i < studyPlans.size(); i++) {
            System.out.println("\n[" + (i+1) + "] " + studyPlans.get(i));
        }
        
        System.out.print("\nEnter number to delete (0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        if (choice > 0 && choice <= studyPlans.size()) {
            StudyPlan removed = studyPlans.remove(choice-1);
            System.out.println("Deleted: " + removed.getTask());
        } else if (choice != 0) {
            System.out.println("Invalid choice.");
        }
    }

    private boolean isValidTime(String time) {
        return time.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
