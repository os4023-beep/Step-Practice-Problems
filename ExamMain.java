abstract class Question {
    String correct, answer;
    double points;

    Question(String c, String a, double p) {
        correct = c;
        answer = a;
        points = p;
    }

    abstract double score();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double score() {
        return answer.equals(correct) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double score() {
        return answer.equals(correct) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double score() {
        int n = 0;

        for (String k : correct.toLowerCase().split(","))
            if (answer.toLowerCase().contains(k.trim()))
                n++;

        return n >= 2 ? points * .75 :
               n == 1 ? points * .5 : 0;
    }
}

public class ExamMain {
    public static void main(String[] args) {

        Question[] q = {
            new MCQ("Paris", "Paris", 10),
            new TF("False", "True", 5),
            new Essay(
                "Inheritance, Polymorphism, Encapsulation",
                "Polymorphism is one.",
                20
            ),
            new Essay(
                "Abstraction, Composition",
                "I talked about abstraction.",
                15
            )
        };

        double total = 0;

        for (Question x : q) {
            double s = x.score();
            System.out.printf("%.2f%n", s);
            total += s;
        }

        System.out.printf("Total Score: %.2f", total);
    }
}