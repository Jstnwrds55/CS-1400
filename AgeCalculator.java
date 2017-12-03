import java.util.InputMismatchException;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {

        // declare variables
        String firstName;
        String lastName;
        int age;

        // declare scanner and run program
        Scanner in = new Scanner(System.in);
        System.out.print("Input your first name: ");
        firstName = in.next();
        System.out.print("Input your last name: ");
        lastName = in.next();

        // run this until the user puts in a number for their age
        while (true) {
            System.out.print("Input your age: ");
            try {
                age = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Make sure you put your age in years!");
                in.nextLine();
            }
        }

        // print out the final calculations
        System.out.println("\n" + lastName + ", " + firstName + "\n" + (age * 12) + " months old.\n" + (age * 365) +
                " days old.\n" + (age * 365 * 24) + " hours old.\n" + (age * 365 * 24 * 60) + " minutes old.\n" +
                (age * 365 * 24 * 60 * 60) + " seconds old.");


    }
}
