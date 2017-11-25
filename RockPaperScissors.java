import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String getUserChoice() {
        Scanner in = new Scanner(System.in);

        // loop until the user puts in a valid input
        while (true) {
            System.out.println("Rock, paper or scissors?");
            String userChoice = in.next();

            // return respective choice
            if (userChoice.equalsIgnoreCase("rock")) {
                return ("rock");
            } else if (userChoice.equalsIgnoreCase("paper")) {
                return ("paper");
            } else if (userChoice.equalsIgnoreCase("scissors")) {
                return ("scissors");
            } else {
                System.out.println("Sorry, \"" + userChoice + "\" is not a valid option.\n");
                in.nextLine();
            }
        }

    }

    public static String getCPUChoice() {

        // put choices in array and chose random from it
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        return (choices[random.nextInt(choices.length)]);
    }

    public static String pickWinner(String userChoice, String cpuChoice) {

        // nested switch statements to hit all bases with comparisons
        switch (userChoice) {

            case "rock":
                switch (cpuChoice) {
                    case "rock":
                        return "Tie";
                    case "paper":
                        return "Computer";
                    case "scissors":
                        return "User";
                }
                break;

            case "paper":
                switch (cpuChoice) {
                    case "rock":
                        return "User";
                    case "paper":
                        return "Tie";
                    case "scissors":
                        return "Computer";
                }
                break;

            case "scissors":
                switch (cpuChoice) {
                    case "rock":
                        return "Computer";
                    case "paper":
                        return "user";
                    case "scissors":
                        return "Tie";
                }
                break;
        }
        return null; // required return statement, will never be called.
    }
}