package assignmentprob;

import java.util.Scanner;

interface SaverMode {
    double reduceUnits(double units);
}

abstract class Appliance {
    double hours;
    static final double COST_PER_UNIT = 8;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();
    abstract String getName();

    double calculateUnits() {
        return getPower() * hours / 1000;
    }

    double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getName() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }

    String getName() {
        return "AC";
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getName() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }

    String getName() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        boolean[] saver = new boolean[n];
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            saver[i] = sc.hasNext("SAVER");
            if (saver[i]) {
                sc.next();
            }

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AC(hours);
                    break;
                case "TV":
                    appliances[i] = new TV(hours);
                    break;
                case "WASHER":
                    appliances[i] = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance");
            }
        }

        for (int i = 0; i < n; i++) {
            Appliance a = appliances[i];
            double units = a.calculateUnits();

            if (saver[i]) {
                if (a instanceof SaverMode) {
                    SaverMode mode = (SaverMode) a;
                    units = mode.reduceUnits(units);
                } else {
                    System.out.printf(
                        "%s: saver mode not supported%n", a.getName());
                    continue;
                }
            }

            double cost = a.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                a.getName(), units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
