package assignmentprob;


import java.util.Scanner;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    double km;
    static final double MIN_FARE = 100;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();
    abstract String getType();

    double calculateFare() {
        return Math.max(km * getRate(), MIN_FARE);
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        String[] times = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            times[i] = sc.next().toUpperCase();

            switch (type) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;
                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }
        }

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];

            if (times[i].equals("NIGHT")) {
                if (cab instanceof NightService) {
                    NightService nightCab = (NightService) cab;
                    double fare = nightCab.applyNightCharge(
                        cab.calculateFare()
                    );

                    System.out.printf("%s: %.2f%n",
                        cab.getType(), fare);
                    total += fare;
                } else {
                    System.out.printf(
                        "%s: night service not available%n",
                        cab.getType()
                    );
                }
            } else {
                double fare = cab.calculateFare();
                System.out.printf("%s: %.2f%n",
                    cab.getType(), fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
