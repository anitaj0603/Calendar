public class Event implements Comparable<Event> {
    private String name;
    private String date;  
    private String startTime; 
    private String endTime;   
    private String additionalInfo;

    public Event(String name, String date, String startTime, String endTime, String additionalInfo) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.additionalInfo = additionalInfo;
    }

    public int compareTo(Event other) {
        return this.date.compareTo(other.date);
    }A

    public boolean overlapsWith(Event other) {
        if (!this.date.equals(other.date)) {
            return false; 
        }
        
    
        int thisStart = timeToMinutes(this.startTime);
        int thisEnd = timeToMinutes(this.endTime);
        int otherStart = timeToMinutes(other.startTime);
        int otherEnd = timeToMinutes(other.endTime);
        
        return thisStart < otherEnd && otherStart < thisEnd;
    }

    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public String toString() {
        return "Event: " + name + 
               "\nDate: " + date +
               "\nTime: " + startTime + " - " + endTime +
               "\nNotes: " + additionalInfo;
    }

    public String getDate() { return date; }
    public String getName() { return name; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
}
