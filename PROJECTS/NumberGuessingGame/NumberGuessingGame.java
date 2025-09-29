import java.util.*;

/**
 * NumberGuessingGame
 * -------------------
 * A simple console game where the computer picks a random number and the player
 * tries to guess it. After every 5 valid guesses, the player can choose to stop.
 *
 * Features:
 * - Clear prompts and friendly messages
 * - Input validation for integers and range
 * - Small helper methods to keep main logic clean
 */
public class NumberGuessingGame {

    // Configure bounds in one place for easy tweaks later
    private static final int MIN = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");

        // Generate the secret number in the inclusive range [MIN, MAX]
        int secret = MIN + (int) (Math.random() * (MAX - MIN + 1));

        int attempts = 0; // counts only valid, in-range guesses

        // Game loop; use 'break' to exit on win or when the player stops.
        while (true) {
            // Read a valid integer guess within range
            int guess = readIntInRange(sc, "Guess the number between " + MIN + " and " + MAX + ": ", MIN, MAX);
            attempts++; // count only valid attempts

            // Compare the guess with the secret
            if (guess == secret) {
                System.out.println("You guessed the number in " + attempts + " attempts!");
                System.out.println("Congratulations! Thank you for playing.");
                break; // Exit the loop on a correct guess
            } else if (guess > secret) {
                System.out.println("Too high! The number is less than " + guess + ".");
            } else { // guess < secret
                System.out.println("Too low! The number is greater than " + guess + ".");
            }

            // Every 5 valid attempts, offer to stop
            if (attempts % 5 == 0) {
                if (!askToContinue(sc, attempts)) {
                    System.out.println("You gave up! The correct number was: " + secret);
                    break;
                }
            }
        }

        // Close the scanner at the end of the program to prevent resource leaks.
        sc.close();
    }

    /**
     * Read any integer from the user. Keeps prompting until a valid integer is entered.
     */
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            // consume the invalid token and try again
            String bad = sc.next();
            System.out.println("Invalid input '" + bad + "'. Please enter a whole number.");
        }
    }

    /**
     * Read an integer within [min, max]. Re-prompts until a valid, in-range value is given.
     */
    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            int value = readInt(sc, prompt);
            if (value < min || value > max) {
                System.out.println("Out of range. Please enter a number between " + min + " and " + max + ".");
                continue;
            }
            return value;
        }
    }

    /**
     * Ask the player if they wish to continue after a certain number of attempts.
     * Accepts inputs like Yes/Y/No/N (case-insensitive). Defaults to continue on unrecognized input.
     */
    private static boolean askToContinue(Scanner sc, int attempts) {
        System.out.print("You've made " + attempts + " attempts. Do you want to continue? [Yes/No]: ");
        String ans = sc.next();
        if (ans.equalsIgnoreCase("No") || ans.equalsIgnoreCase("N")) {
            return false;
        }
        return true; // continue by default for Yes/Y/others
    }
}
