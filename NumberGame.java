import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0, totalScore = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            rounds++;
            int number = random.nextInt(100) + 1; // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7; // Limiting number of attempts
            boolean guessedCorrectly = false;

            System.out.println(
                    "Round " + rounds + ": Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println(
                            "Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1); // More score for fewer attempts
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + number);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game Over! You played " + rounds + " rounds with a total score of: " + totalScore);
        scanner.close();
    }
}
