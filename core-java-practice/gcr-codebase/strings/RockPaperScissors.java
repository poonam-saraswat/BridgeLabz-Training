import java.util.*;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of games to play: ");
        int numberOfGames = scanner.nextInt();

        String[][] results = new String[numberOfGames][3];
        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.next().toLowerCase();
            String computerChoice = getComputerChoice();

            String winner = determineWinner(userChoice, computerChoice);
            results[i][0] = userChoice;
            results[i][1] = computerChoice;
            results[i][2] = winner;

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }

        String[][] stats = calculateStats(userWins, computerWins, numberOfGames);
        displayResults(results, stats);

        scanner.close();
    }
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int) (Math.random() * 3);
        return choices[index];
    }
    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Draw";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }
    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][2];
        stats[0][0] = "User Wins";
        stats[0][1] = String.valueOf(userWins);
        stats[1][0] = "Computer Wins";
        stats[1][1] = String.valueOf(computerWins);
        return stats;
    }
    public static void displayResults(String[][] results, String[][] stats) {
        System.out.printf("%-15s %-15s %-10s%n", "User Choice", "Computer Choice", "Winner");
        System.out.println("----------------------------------------------");
        for (String[] result : results) {
            System.out.printf("%-15s %-15s %-10s%n", result[0], result[1], result[2]);
        }
        System.out.println("\nStatistics:");
        for (String[] stat : stats) {
            System.out.printf("%-15s : %s%n", stat[0], stat[1]);
        }
    }
}