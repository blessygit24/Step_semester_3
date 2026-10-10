package classproblem;


import java.util.Scanner;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Single extends Room {
    Single(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0;
    }
}

class Shared extends Room {
    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10.0 + 200;
    }
}

public class electricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new Single(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new Shared(units, occupants);
                    break;
                default:
                    room = new AC(units);
            }

            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

