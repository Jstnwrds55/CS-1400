import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsMine {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean playGame = true;
        System.out.print("Welcome to Rock Paper Scissors! ");

        // run until playGame is false
        do {

            // ask how many rounds, run function
            System.out.print("Please enter the amount of rounds would you like to play: ");
            int rounds = getRounds(); // run the function to get rounds amount
            System.out.println("Great! We'll play " + rounds + " rounds! Let's get started...");

            // run the game function and then ask if user wants to play again
            runRounds(rounds);
            System.out.println("Would you like to play again? (y or n): ");

            // if they choose no, change playGame to false, end loop
            if (in.next().equalsIgnoreCase("n")) {
                playGame = false;
            }

        } while (playGame);

        System.out.println("Alrighty, thanks for playing!");
    }

    // get the amount of rounds the user wants to play
    private static int getRounds() {
        Scanner in = new Scanner(System.in);
        int rounds;

        while (true) {

            // try to get a number from the user, if it's not a number, ask for one
            try {
                rounds = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Make sure you choose a number! And an odd one at that. Enter the amount of rounds you'd like to play: ");
                in.nextLine();
                continue;
            }

            // check if the number is odd, if not, ask for an odd number
            if ((rounds % 2) != 0) {
                break;
            } else {
                System.out.print("Make sure you choose an odd number so you can't tie! Enter the amount of rounds you'd like to play: ");
                in.nextLine();
            }
        }
        return rounds;
    }

    private static void runRounds(int roundAmount) {

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        // declare variables needed for choosing play
        String[] choices = {"rock", "paper", "scissors"}; // list of choices for computer
        String userChoice;
        String computerChoice;

        // start each win at 0
        int userWins = 0;
        int computerWins = 0;

        // loop through until it reaches the amount of rounds the user chose
        for (int x = 0; x < roundAmount; x++) {

            System.out.print("\nRock, Paper, or Scissors?: ");
            userChoice = in.next();
            computerChoice = choices[random.nextInt(choices.length)]; // choose random out of choices list

            // if it's a tie, say so, decrement x back to previous, and restart loop
            if (userChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("Looks like that one was a tie.");
                x --;
                continue;
            }
            System.out.print("The computer chose " + computerChoice + ". " );
            /* I could have combined everything to do if (userpaper && comprock) or (userrock && compscissors) user wins
            etc but I thought this laid it out easier to see the logic process */
            switch (userChoice.toLowerCase()) {

                // user chose rock
                case "rock":
                    switch(computerChoice) {

                        // computer chose paper
                        case "paper":
                            computerWins ++;
                            System.out.println("All wrapped in paper, you lost that round!");
                            break;

                        // computer chose scissors
                        case "scissors":
                            userWins ++;
                            System.out.println("Smash! You won that round!");
                            break;
                    }
                    break;

                // user chose paper
                case "paper":
                    switch(computerChoice) {

                        // computer chose rock
                        case "rock":
                            userWins ++;
                            System.out.println("You wrapped him up, you won that round!");
                            break;

                        // computer chose scissors
                        case "scissors":
                            computerWins ++;
                            System.out.println("Snip snip! You lost that round!");
                            break;
                    }
                    break;

                // user chose scissors
                case "scissors":
                    switch(computerChoice) {

                        // computer chose rock
                        case "rock":
                            computerWins ++;
                            System.out.println("Looks like you got crushed, you lost that round.");
                            break;

                        // computer chose scissors
                        case "paper":
                            userWins ++;
                            System.out.println("Snip snip motha-trucka! You won that round!");
                            break;
                    }
                    break;

                // if the user types something other than rock, paper, or scissors, make them type the right darn stuff
                default:
                    System.out.println("But you typed \"" + userChoice + "\". Make sure you choose rock, paper, or scissors!");
                    x --;
            }

        }
        System.out.println("User Wins: " + userWins + "\nComputer Wins: " + computerWins + "\n");

        // print out whether computer or user won
        if (userWins > computerWins) {
            System.out.println("User wins the game!");
        } else {
            System.out.println("Computer wins the game!");
        }

    }

}
