import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RollingDice {
    public static void main(String[] args) {

        // create arraylist for dice
        int rollsAmount = 0;


        // ask user how many times they want to roll, if not a number ask again
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the dice rolling simulator 9000!\n");
        while (true) {
            try {
                System.out.print("How many times would you like to roll the dice?: ");
                rollsAmount = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please make sure you input a number!");
                in.nextLine();
            }
        }

        // call dice rolling function
        diceRoller(rollsAmount);


    }

    // method for actual dice rolling sim
    private static void diceRoller(int rolls) {

        // create dice array
        int dice[] = new int[6];
        for (int i = 1; i < 7; i ++) {
            dice[i-1] = i;
        }

        // create 2d array to hold values
        int[][] histogram = new int[12][2];
        for (int x = 1; x < 12; x ++) {
            histogram[x][0] = x + 1;
            histogram[x][1] = 0;
        }

        // let the dice rolling commence!
        for (int y = 0; y < rolls; y ++) {
            int dice1 = new Random().nextInt(dice.length) + 1;
            int dice2 = new Random().nextInt(dice.length) + 1;
            int diceRoll = dice1 + dice2;

            // increase int by 1 for the respective roll
            histogram[diceRoll - 1][1] = histogram[diceRoll - 1][1] + 1;

        }
        // change each value to a percentage
        for (int j = 1; j < 12; j ++) {
            histogram[j][1] = (((histogram[j][1] * 100) / (rolls)));
        }

        // print out histogram to user
        System.out.println("DICE ROLLING SIMULATOR 9000 RESULTS");
        System.out.println("1 \"*\" represents 1% of the total dice rolls.");
        System.out.println("Total rolls: " + rolls);
        for (int z = 1; z < 12; z ++) {
            System.out.print(histogram[z][0] + ": " + new String(new char[histogram[z][1]]).replace("\0", "*") + "\n");
        }

    }
}
