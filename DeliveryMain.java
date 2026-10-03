abstract class Delivery {
    double w, d;

    Delivery(double w, double d) {
        this.w = w;
        this.d = d;
    }

    abstract double fee();
    abstract String type();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double fee() {
        return 5 + .5 * w + .1 * d;
    }

    String type() {
        return "STANDARD";
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double fee() {
        return 15 + w + .2 * d;
    }

    String type() {
        return "EXPRESS";
    }
}

class International extends Delivery {
    double customs;

    International(double w, double d, double c) {
        super(w, d);
        customs = c;
    }

    double fee() {
        return 25 + 2 * w + .5 * d + customs;
    }

    String type() {
        return "INTERNATIONAL";
    }
}

public class DeliveryMain {
    public static void main(String[] args) {

        Delivery[] x = {
            new Standard(10, 50),
            new Express(5, 20),
            new International(20, 100, 30)
        };

        double total = 0;

        for (Delivery d : x) {
            double f = d.fee();
            System.out.printf("%s: %.2f%n", d.type(), f);
            total += f;
        }

        System.out.printf("Total: %.2f", total);
    }
}