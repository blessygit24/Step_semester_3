package classproblem;

class Scorecard {
    private boolean[] results;
    private int count;

    // Constructor
    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
    }

    // Record an answer
    void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;
            count++;
        } else {
            System.out.println("No more answers can be recorded.");
        }
    }

    // Calculate score
    int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class Quiz {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score = " + sc.getScore());
    }
}