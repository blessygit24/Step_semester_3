package classproblem;

public class MessWallet {

    private double balance;

    // Constructor
    public MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Negative opening balance. Starting with 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Top-up method
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
        } else {
            balance = balance + amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    // Deduct method
    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction rejected: amount must be greater than 0");
        } else if (amount > balance) {
            System.out.println("Deduction rejected: insufficient balance");
        } else {
            balance = balance - amount;
            System.out.println("Balance after deduction: " + balance);
        }
    }

    // Get balance method
    public double getBalance() {
        return balance;
    }

    // Main method
    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(100);

        System.out.println("Initial balance: " + wallet.getBalance());

        wallet.topUp(50);

        wallet.deduct(30);

        System.out.println("Final balance: " + wallet.getBalance());
    }
}