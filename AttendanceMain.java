class AttendanceSheet {
    private String[] names;
    private int count;

    AttendanceSheet(int size) {
        names = new String[size];
    }

    void markPresent(String name) {
        if (!isPresent(name))
            names[count++] = name;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++)
            if (names[i].equals(name))
                return true;

        return false;
    }

    int getPresentCount() {
        return count;
    }
}

public class AttendanceMain {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(
            "Present count: " + sheet.getPresentCount()
        );

        System.out.println(
            "Ben present: " + sheet.isPresent("Ben")
        );

        System.out.println(
            "Chen present: " + sheet.isPresent("Chen")
        );
    }
}