abstract class Payment {
    double amount;

    Payment(double a) {
        amount = a;
    }

    abstract double calc();
    abstract String type();
}

class Card extends Payment {
    Card(double a) {
        super(a);
    }

    double calc() {
        return amount * 1.02;
    }

    String type() {
        return "CARD";
    }
}

class Wallet extends Payment {
    Wallet(double a) {
        super(a);
    }

    double calc() {
        return amount * 1.01;
    }

    String type() {
        return "WALLET";
    }
}

class Bank extends Payment {
    Bank(double a) {
        super(a);
    }

    double calc() {
        return amount;
    }

    String type() {
        return "BANKTRANSFER";
    }
}

public class PaymentMain {
    public static void main(String[] args) {

        Payment[] p = {
            new Card(1000),
            new Wallet(500),
            new Bank(2000)
        };

        double total = 0;

        for (Payment x : p) {
            double a = x.calc();
            System.out.printf("%s: %.2f%n", x.type(), a);
            total += a;
        }

        System.out.printf("Total: %.2f", total);
    }
}