package assignmentprob;


import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    double weight, declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
    abstract String getType();

    double getInsurance() {
        return 0;
    }

    double calculateTotal() {
        return calculateCharge() + getInsurance();
    }
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    double getInsurance() {
        return calculateInsurance();
    }

    String getType() {
        return "EXPRESS";
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    double getInsurance() {
        return calculateInsurance();
    }

    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels[i] = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new Fragile(weight, value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid parcel type");
            }
        }

        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = p.getInsurance();
            double total = p.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                p.getType(), charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}

