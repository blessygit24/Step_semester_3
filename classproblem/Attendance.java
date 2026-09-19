package classproblem;

class AttendanceSheet {
    private String[] students;
    private int count;

    // Constructor
    AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        count = 0;
    }

    // Mark a student present
    void markPresent(String name) {
        // Check for duplicate
        if (isPresent(name)) {
            return;
        }

        // Check if array is full
        if (count < students.length) {
            students[count] = name;
            count++;
        } else {
            System.out.println("Attendance sheet is full.");
        }
    }

    // Return number of present students
    int getPresentCount() {
        return count;
    }

    // Check whether student is present
    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class Attendance {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count = " + sheet.getPresentCount());

        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));
        System.out.println("Is Chen present? " + sheet.isPresent("Chen"));
    }
}