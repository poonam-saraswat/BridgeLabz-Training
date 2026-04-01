import java.util.Random;

public class SnakeAndLadder {
    static final int WINNING_POSITION = 100;
    static Random random = new Random();

    // Roll the dice (UC2)
    public static int rollDice() {
        return random.nextInt(6) + 1;
    }

    // Get option: No Play, Ladder, Snake (UC3)
    public static int getOption() {
        return random.nextInt(3); // 0 = No Play, 1 = Ladder, 2 = Snake
    }

    // Play single player game (UC1–UC6)
    public static void playSinglePlayer() {
        int position = 0;
        int diceCount = 0;

        while (position < WINNING_POSITION) {
            int dice = rollDice();
            diceCount++;
            int option = getOption();

            switch (option) {
                case 0: // No Play
                    break;
                case 1: // Ladder
                    if (position + dice <= WINNING_POSITION) {
                        position += dice;
                    }
                    break;
                case 2: // Snake
                    position -= dice;
                    if (position < 0) {
                        position = 0;
                    }
                    break;
            }

            System.out.println("Dice: " + dice + " | Option: " + optionName(option) + " | Position: " + position);
        }

        System.out.println("Player won the game in " + diceCount + " dice rolls!");
    }

    // Play two player game (UC7)
    public static void playTwoPlayers() {
        int position1 = 0, position2 = 0;
        int diceCount1 = 0, diceCount2 = 0;
        boolean player1Turn = true;

        while (position1 < WINNING_POSITION && position2 < WINNING_POSITION) {
            int dice = rollDice();
            int option = getOption();

            if (player1Turn) {
                diceCount1++;
                position1 = updatePosition(position1, dice, option);
                System.out.println("Player 1 rolled " + dice + " | " + optionName(option) + " | Position: " + position1);

                if (option == 1) { // Ladder → play again
                    continue;
                }
                player1Turn = false;
            } else {
                diceCount2++;
                position2 = updatePosition(position2, dice, option);
                System.out.println("Player 2 rolled " + dice + " | " + optionName(option) + " | Position: " + position2);

                if (option == 1) { // Ladder → play again
                    continue;
                }
                player1Turn = true;
            }
        }

        if (position1 == WINNING_POSITION) {
            System.out.println("Player 1 wins in " + diceCount1 + " rolls!");
        } else {
            System.out.println("Player 2 wins in " + diceCount2 + " rolls!");
        }
    }

    // Update position with rules (UC4–UC5)
    public static int updatePosition(int position, int dice, int option) {
        switch (option) {
            case 0: // No Play
                break;
            case 1: // Ladder
                if (position + dice <= WINNING_POSITION) {
                    position += dice;
                }
                break;
            case 2: // Snake
                position -= dice;
                if (position < 0) {
                    position = 0;
                }
                break;
        }
        return position;
    }

    // Helper to print option name
    public static String optionName(int option) {
        switch (option) {
            case 0: return "No Play";
            case 1: return "Ladder";
            case 2: return "Snake";
            default: return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Single Player Game ===");
        playSinglePlayer();

        System.out.println("\n=== Two Player Game ===");
        playTwoPlayers();
    }
}