import java.util.Random;
import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int score = 0;
        String playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                try {
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess < lowerBound || guess > upperBound) {
                        System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                        score++;
                        guessedCorrectly = true;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("Game over! Your final score: " + score + " rounds won.");
        scanner.close();
    }
}
