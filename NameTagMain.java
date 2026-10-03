class NameTag {
    private final String first, last;

    NameTag(String name) {
        String[] x = name.split(" ");
        first = x[0];
        last = x[1];
    }

    String getNickname() {
        return first + " " + last.charAt(0) + ".";
    }
}

public class NameTagMain {
    public static void main(String[] args) {

        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}