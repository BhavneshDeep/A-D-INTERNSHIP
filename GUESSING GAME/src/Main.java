import java.util.Random;
import java.util.Scanner;

 class GuessingGame {

    public static void main(String[] args) {
        // Create an instance of Random to generate random numbers
        Random random = new Random();
        // Generate a random number between -100 and 50
        int secretNumber = random.nextInt(151) - 100;

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Variable to keep track of the number of attempts
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have picked a number between -100 and 50. Can you guess it?");

        // Loop until the user guesses the correct number
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guessing number : ");
            int userGuess = scanner.nextInt(); // Read user's guess

            attempts++; // Increment the attempt counter

            // Check if the guess is too high, too low, or correct
            if (userGuess > secretNumber) {
                System.out.println(" guessing value is high! Try again.");
            } else if (userGuess < secretNumber) {
                System.out.println("guessing value is low! Try again.");
            } else {
                System.out.println("Congratulations! You've guessed the correct number.");
                hasGuessedCorrectly = true; // Exit the loop
            }
        }

        // Display the number of attempts
        System.out.println("You guessed the number in " + attempts + " attempts.");

        // Close the scanner
        scanner.close();
    }
}
