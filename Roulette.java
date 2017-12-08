import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Roulette {

    Random random = new Random();

    public Double betOnce(Scanner in, Double bet) {

        // declare variables
        int number = random.nextInt(37);
        int userChoice;
        int numberChoice;
        Double finalAmount = bet;

        // ask for a valid choice and break when they give it
        while (true) {
            System.out.println("Do you want to bet on 1) Low 2) High or 3) A Number?");
            try {
                userChoice = in.nextInt();

                // if the number they typed is 1-3 then break
                if (userChoice > 0 && userChoice < 4) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Make sure you choose 1, 2, or 3!");
                in.next();
            }
        }

        // if they choose 1
        if (userChoice == 1) {

            // tell user number, decide if they won or lost
            System.out.println("The number was " + number);
            if (number < 19 && number != 0) {
                System.out.println("Congratulations, you won and doubled your bet!");
                finalAmount *= 2;
            } else {
                System.out.println("Sorry, you lost!");
                finalAmount = 0.0;
            }

        // if they choose 2
        } else if (userChoice == 2) {

            // tell user number and decide if they won
            System.out.println("The number was " + number);
            if (number > 18 && number != 0) {
                System.out.println("Congratulations, you won and doubled your bet!");
                finalAmount *= 2;
            } else {
                System.out.println("Sorry, you lost!");
                finalAmount = 0.0;
            }

        // if they choose 3
        } else if (userChoice == 3) {

            // ask for a number until they give a valid one
            while (true) {

                System.out.println("What number would you like to bet on (between 1 and 36)?");
                try {
                    numberChoice = in.nextInt();

                    // if the number they chose is 1-36 then break
                    if (numberChoice > 0 && numberChoice < 37) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Make sure you type a number between 1 and 36");
                }
            }

            // after they made a valid choice, give number and decide if they won
            System.out.println("The number was " + number);
            if (number == numberChoice) {
                System.out.println("Congratulations! You guessed the number and 34x your bet!");
                finalAmount *= 34;
            } else {
                finalAmount = 0.0;
            }
        }

        // finally return the final amount
        return finalAmount;
    }

}

