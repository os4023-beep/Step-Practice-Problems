import java.util.*;

public class Problem1_RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove))
            return "Draw";

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

        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        int rounds = 5;

        System.out.println("Round | Player | Computer | Result");

        for (int i = 1; i <= rounds; i++) {

            System.out.print("Enter move for round " + i + ": ");
            String player = sc.nextLine();

            String computer = moves[random.nextInt(3)];

            String result = playRound(player, computer);

            System.out.println(i + " | " + player
                    + " | " + computer + " | " + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        double winPercentage = wins * 100.0 / rounds;

        System.out.println("Wins: " + wins
                + " | Losses: " + losses
                + " | Draws: " + draws
                + " | Win % = " + winPercentage + "%");

        sc.close();
    }
}