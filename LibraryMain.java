import java.time.LocalDate;

abstract class Item {
    String title;

    Item(String t) {
        title = t;
    }

    abstract int days();

    void show() {
        System.out.println(
            title + ": " +
            LocalDate.of(2023, 10, 26).plusDays(days())
        );
    }
}

class Book extends Item {
    Book(String t) {
        super(t);
    }

    int days() {
        return 14;
    }
}

class DVD extends Item {
    DVD(String t) {
        super(t);
    }

    int days() {
        return 7;
    }
}

class Magazine extends Item {
    Magazine(String t) {
        super(t);
    }

    int days() {
        return 3;
    }
}

public class LibraryMain {
    public static void main(String[] args) {

        Item[] x = {
            new Book("1984"),
            new DVD("The Matrix"),
            new Magazine("Forbes Issue 500")
        };

        for (Item i : x)
            i.show();
    }
}