
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int lowerBound = 1; // Lower bound of the range
            int upperBound = 100; // Upper bound of the range
            int maxAttempts = 10; // Maximum number of attempts allowed
            int score = 0; // Player's score
            boolean playAgain = true; // Controls whether the game continues

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("You have " + maxAttempts + " attempts to guess the number between " + lowerBound + " and " + upperBound + ".");

            while (playAgain) {
                // Generate a random number within the range
                int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                int attempts = 0; // Track the number of attempts
                boolean guessedCorrectly = false; // Track if the user guessed correctly

                System.out.println("\nI've picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

                // Loop for guessing
                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == randomNumber) {
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        score += (maxAttempts - attempts + 1); // Award points based on attempts
                        guessedCorrectly = true;
                    } else if (guess < randomNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                }

                // If the user runs out of attempts
                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The number was " + randomNumber + ".");
                }

                // Ask if the user wants to play again
                System.out.print("Your current score is: " + score + ". Play again? (yes/no): ");
                String playAgainInput = scanner.next().toLowerCase();
                playAgain = playAgainInput.equals("yes");
            }

            System.out.println("Thanks for playing! Your final score is: " + score);
        }
    }
}