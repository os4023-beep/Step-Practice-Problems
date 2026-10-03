abstract class Transport {
    double distance;

    Transport(double d) {
        distance = d;
    }

    abstract double fare();
    abstract String type();
}

class Bus extends Transport {
    Bus(double d) {
        super(d);
    }

    double fare() {
        return Math.min(2 + .1 * distance, 10);
    }

    String type() {
        return "BUS";
    }
}

class Train extends Transport {
    Train(double d) {
        super(d);
    }

    double fare() {
        return 3 + .15 * distance;
    }

    String type() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    double factor;

    Metro(double d, double f) {
        super(d);
        factor = f;
    }

    double fare() {
        return (1.5 + .2 * distance) * factor;
    }

    String type() {
        return "METRO";
    }
}

public class TransportMain {
    public static void main(String[] args) {

        Transport[] t = {
            new Bus(15),
            new Train(50),
            new Metro(10, 1.5)
        };

        double total = 0;

        for (Transport x : t) {
            double f = x.fare();
            System.out.printf("%s: %.2f%n", x.type(), f);
            total += f;
        }

        System.out.printf("Total: %.2f", total);
    }
}