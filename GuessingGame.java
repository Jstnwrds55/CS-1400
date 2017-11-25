import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        // initialize number generator and Scanner
        Random numGenerator = new Random();
        Scanner in = new Scanner(System.in);

        // declare/assign variables
        int computerNumber;
        int userGuess = 0;
        int guessCounter = 0;
        boolean playGame = true;

        // this loop runs as long as playGame == true
        do {
            computerNumber = numGenerator.nextInt(100) + 1;
            System.out.println("Welcome to my guessing game! I am thinking a number between 1 and 100, " +
                    "try and guess what it is!\n" );

            // this loop runs as long as the user hasn't guessed the computer's number
            do {
                System.out.print("Enter your guess: ");

                // make sure the user input a number and not text
                try {
                    userGuess = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Pick a number, no letters silly!\n");
                    in.nextLine();
                    continue; // Restart loop if user didn't type a number
                }

                // check if number is within range
                if (userGuess > 0 && userGuess < 101) {
                    guessCounter ++;

                    // if the number is within the range, tell user whether too high, low, or right on
                    if (userGuess < computerNumber) {
                        System.out.println("Awweee too low! Guess higher.\n");
                    } else if (userGuess > computerNumber) {
                        System.out.println("Drats, too high! Guess lower.\n");
                    } else {
                        System.out.println("You got it! The number was " + computerNumber + ". It took you " + guessCounter + " guesses!\n");
                        in.nextLine();
                        guessCounter = 0; // if they got it, set the counter back to zero for the next round
                    }

                // if it's not within range, ask for a number in the range
                } else {
                    System.out.println("Make sure your number is between 1 and 100!\n");
                }

            } while (userGuess != computerNumber); // if user guessed the number, this loop breaks

            // ask if user wants to play again and store the value
            System.out.println("Would you like to play again? (y or n)");
            String playAgain = in.next();

            // this loop runs until the user types either y or n
            do {

                if (playAgain.equalsIgnoreCase("Y")) {
                    playGame = true; // set to true, play again
                    break;
                } else if (playAgain.equalsIgnoreCase("N")) {
                    playGame = false; // set to false, quit game
                    System.out.println("Alrighty, thanks for playing!");
                    break;
                }

                // if it wasn't y or n, tell them to choose y or n and flush buffer
                System.out.println("Choose y or n silly!");
                in.nextLine();

            } while (!playAgain.equalsIgnoreCase("Y") && !playAgain.equalsIgnoreCase("N"));
                // loop ends if playAgain is y or n

        } while (playGame); // loop ends if playGame is false
    }
}
