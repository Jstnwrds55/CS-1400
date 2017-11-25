import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class RetirementAge {

    public static void main (String[] args) {

        // Main program asking user for info and storing it in variables
        String userMonth = askMonth ();
        int userDay = askNumber("day");
        int userYear = askNumber("year");
        int retirementYear = userYear + 67; // Add 67 to birth year

        // Print out date user will hopefully retire
        System.out.println("You will (hopefully) retire on " + userMonth + " " + userDay + ", " + retirementYear);
    }

    // Function for making sure the month they input is actually a month
    private static String askMonth () {
        Scanner in = new Scanner(System.in);
        String[] months = {"january", "february", "march", "april", "may", "june", "july", "august", "september",
        "october", "november", "december"};

        // Loop forevveerrr until a return statement ends loop
        while (true) {
            System.out.print("Enter the month you were born: ");
            String userMonth = in.next(); // Take user input

            // If month entered is in months array, return to variable.
            if (Arrays.asList(months).contains(userMonth.toLowerCase())) {
                return userMonth;

            // Otherwise ask for valid month and loop
            } else {
                System.out.println("Please enter a valid month");
            }
        }
    }

    // function to make sure the user input for date and year is actually a number
    private static int askNumber (String type) {
        Scanner in = new Scanner(System.in);

        // Loop until the user inputs a number and outputInt is changed
        while (true) {
            System.out.print("Please enter the " + type + " you were born: ");

            // Try to get user input as Int
            try {
                return in.nextInt();

            // If it's not a number, catch error and ask for a number
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number");
                in.nextLine(); // Flush buffer so it doesn't infinitely print hahaha
            }
        }
    }
}
