import java.util.Scanner;
import java.util.Random;   
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100 (inclusive).");
        System.out.println("I will try to guess it!");

        int low = 1;
        int high = 100;
        int attempts = 0;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            int guess = generateGuess(low, high);
            attempts++;
            System.out.printf("Is your number %d? (h for high, l for low, c for correct): ", guess);
            char feedback = scanner.next().toLowerCase().charAt(0);

            if (feedback == 'c') {
                guessedCorrectly = true;
                System.out.printf("Yay! I guessed your number %d in %d attempts.%n", guess, attempts);
            } else if (feedback == 'h') {
                high = guess - 1;
            } else if (feedback == 'l') {
                low = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'h', 'l', or 'c'.");
            }
        }

        scanner.close();
    }

    // Method to generate a random guess between low and high
    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
}
