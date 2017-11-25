import java.util.InputMismatchException;
import java.util.Scanner;

public class DankBank {
    public static void main(String[] args) {

        // define variables
        String userName;
        double amount = 0;
        int choice;
        Scanner in = new Scanner(System.in);

        // get user info and generate an instance of BankAccount
        System.out.println("Hello! Please enter a name to create an account: ");
        userName = in.nextLine();
        BankAccount u1 = new BankAccount(userName, 37330);

        // loop until user choose option 4
        while (true) {

            // loop until user chooses a valid option
            while (true) {
                System.out.println("\nPress 1 to make a deposit\nPress 2 to make a withdrawal\nPress 3 to view " +
                        "account information\nPress 4 to quit");

                // check if it's an int and if it's between 1 and 4
                try {
                    choice = in.nextInt();
                    if (0 < choice && 5 > choice) {
                        break;
                    }
                } catch (InputMismatchException e) {
                }
                System.out.println("Make sure you choose one of the options!");
                in.nextLine();
            }

            // if they choose 1
            if (choice == 1) {

                // loop until they choose a valid number amount to deposit
                while (true) {
                    System.out.println("\nHow much would you like to deposit today?");

                    // make sure they choose a number amount
                    try {
                        amount = in.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                    }
                    System.out.println("Make sure you type a number amount!");
                    in.nextLine();
                }

            // if they choose 2
            } else if (choice == 2) {

                // loop until they choose a valid number amount
                while (true) {
                    System.out.println("\nHow much would you like to withdraw today?");

                    // make sure they choose a number account
                    try {
                        amount = in.nextDouble() * -1;
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Make sure you type a number amount!");
                    }
                    in.nextLine();
                }

            // if they choose 3, print out stuff and thangs
            } else if (choice == 3) {
                System.out.println("\nName: " + u1.getName() + "\nAccount #: " + u1.getAccountNum() +
                        "\nBalance: $" + u1.getBalance());

            // if they choose 4, exit
            } else if (choice == 4) {
                System.out.println("Thanks for banking with us!");
                break;
            }

            u1.deposit(amount); // run function from BankAccount
            amount = 0; // set amount back to 0 for loop

        }

    }
}
