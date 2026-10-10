package classproblem;


import java.util.Scanner;

abstract class Booking {
    double distance;
    static final double BOOKING_FEE = 50.0;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }

    abstract String getMode();
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 2;
    }

    @Override
    String getMode() {
        return "BUS";
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return distance * 1.5;
    }

    @Override
    String getMode() {
        return "TRAIN";
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 2500 + distance * 4;
    }

    @Override
    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new Bus(distance);
                    break;
                case "TRAIN":
                    bookings[i] = new Train(distance);
                    break;
                case "FLIGHT":
                    bookings[i] = new Flight(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }
        }

        for (Booking booking : bookings) {
            System.out.printf("%s: %.2f%n",
                booking.getMode(), booking.calculateTotal());
        }

        sc.close();
    }
}

