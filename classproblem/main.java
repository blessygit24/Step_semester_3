package classproblem;

class PiggyBank {
    private double savings;
    private final String id;

    // Constructor
    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    // Deposit money
    void deposit(double amount) {
        savings = savings + amount;
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount <= savings) {
            savings = savings - amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    // Check savings
    double getSavings() {
        return savings;
    }
}

public class main {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(10000);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(3900);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings = " + pb.getSavings());
    }
}