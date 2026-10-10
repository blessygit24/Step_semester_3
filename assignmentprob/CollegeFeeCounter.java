package assignmentprob;


import java.util.Scanner;

abstract class Student {
    String name;
    static final double TUITION = 40000;
    static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
    abstract boolean usesBus();
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return TUITION + (usesBus() ? TRANSPORT_FEE : 0);
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return TUITION + 60000;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return TUITION / 2 + (usesBus() ? TRANSPORT_FEE : 0);
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new Scholar(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }
        }

        for (Student s : students) {
            double fee = s.calculateFee();
            System.out.printf("%s: %.2f%n", s.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
