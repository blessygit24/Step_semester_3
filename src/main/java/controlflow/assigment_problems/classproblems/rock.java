package controlflow.assigment_problems.classproblems;


    import java.util.Scanner;

public class rock {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock")
                && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper")
                && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors")
                && computerMove.equalsIgnoreCase("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 5;

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Round " + (i + 1)
                    + " - Enter Rock, Paper or Scissors: ");

            playerMoves[i] = sc.next();

            int random = (int) (Math.random() * 3);

            if (random == 0) {
                computerMoves[i] = "Rock";
            } else if (random == 1) {
                computerMoves[i] = "Paper";
            } else {
                computerMoves[i] = "Scissors";
            }

            results[i] = playRound(playerMoves[i], computerMoves[i]);

            System.out.println("Computer: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
            System.out.println();

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = ((double) wins / n) * 100;

        System.out.println("\nFINAL SUMMARY");
        System.out.println("---------------------------------------------");

        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move",
                "Computer Move", "Result");

        for (int i = 0; i < n; i++) {

            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("---------------------------------------------");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        sc.close();
    }
}
    

