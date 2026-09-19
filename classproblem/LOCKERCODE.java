package classproblem;
class Locker {
    private final int lockerNumber;
    private String combination;

    // Constructor
    Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    // Change combination
    void changeCode(String oldCode, String newCode) {
        if (combination.equals(oldCode)) {
            combination = newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Incorrect old code. Code not changed.");
        }
    }
}

public class LOCKERCODE {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");

        l.changeCode("0000", "9999");
    }
}
