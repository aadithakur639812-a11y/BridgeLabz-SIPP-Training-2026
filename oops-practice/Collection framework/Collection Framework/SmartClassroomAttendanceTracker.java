import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmartClassroomAttendanceTracker {
    private final HashMap<String, ArrayList<String>> attendanceBySubject = new HashMap<>();

    public boolean markAttendance(String subject, String studentName) {
        ArrayList<String> students = attendanceBySubject.computeIfAbsent(subject, key -> new ArrayList<>());
        if (students.contains(studentName)) {
            System.out.println(studentName + " is already marked present in " + subject + ".");
            return false;
        }
        students.add(studentName);
        return true;
    }

    public void displayAttendance() {
        for (Map.Entry<String, ArrayList<String>> entry : attendanceBySubject.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println("Present students: " + entry.getValue());
            System.out.println("Total present: " + entry.getValue().size());
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();
        tracker.markAttendance("Java", "Aisha");
        tracker.markAttendance("Java", "Rohan");
        tracker.markAttendance("Java", "Aisha");
        tracker.markAttendance("Database", "Aisha");
        tracker.markAttendance("Database", "Meera");
        tracker.displayAttendance();
    }
}
