package classproblem;
import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class Basic extends Plan {
    Basic(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 365;
    }
}

public class renewal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan;

            switch (type) {
                case "BASIC":
                    plan = new Basic(name, startDate);
                    break;
                case "STANDARD":
                    plan = new Standard(name, startDate);
                    break;
                default:
                    plan = new Premium(name, startDate);
            }

            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.printf("%s: %s%n", name, renewalDate);
        }

        sc.close();
    }
}
