import java.util.InputMismatchException;
import java.util.Scanner;

public class BMICalc {
    public static void main(String[] args) {

        // get height in inches from user, run function to make sure it's a number
        System.out.print("Enter height in inches: ");
        double userHeight = numChecker("height", "inches");

        // get weight in pounds from user, run function to make sure it's a number
        System.out.print("Enter weight in pounds: ");
        double userWeight = numChecker("weight", "pounds");

        // calculate BMI and report it back rounded to one decimal
        double userBMI = Math.round((((704 * userWeight) / (userHeight * userHeight)) * 10));
        userBMI /= 10;
        System.out.println("\nHeight = " + userHeight + "\"\n" + "Weight = " + userWeight + " pounds\n" +
                "Body mass index = " + userBMI);
    }

    // function for checking if the user input is a valid number
    private static double numChecker(String numType, String measureType) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                double userNumber = in.nextDouble();

                // create error for negative input
                if (userNumber <= 0) {
                    throw new IllegalArgumentException("Number must be greater than 0");
                }
                return userNumber;

            // catch if they put in a string instead of a number
            } catch (InputMismatchException e) {
                System.out.println("Invalid " + numType + ", make sure it's a decimal in " + measureType + ".");
                in.nextLine();
                System.out.print("Please re-enter your " + numType + ": ");

            // catch if they put a negative number
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid " + numType + ", make sure your number is greater than zero!");
                in.nextLine();
                System.out.print("Please re-enter your " + numType + ": ");
            }

        }
    }
}
