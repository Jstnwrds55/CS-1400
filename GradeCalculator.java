import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GradeCalculator {


    // create a class for student information
    public static class StudentInformation {

        // declare all variables for student
        int studentID;
        String lastName;
        String firstName;
        Double[] grades = new Double[4]; // grades are in list
        Double totalScore;
        char letterGrade;

        // initialize object with ID
        public StudentInformation(int ID) {
            this.studentID = ID;
        }
    }

    public static void main(String[] args) {

        // declare and initialize variables
        List<StudentInformation> users = new ArrayList<>();
        List<Integer> idList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        // get student ID and create instance of StudentInformation class object
        System.out.println("Welcome to the grade calculator 9000.");

        // loop until user closes
        while (true) {
            int arrayPosition = 0; // set position at 0 to track later

            // call getID function to get the ID of the student
            int userID = getID();

            // if the function returns 0 meaning they typed 'q', break loop
            if (userID == 0) {
                break;

            // otherwise
            } else {

                // loop through list and find out where the ID is in the index
                for (int x : idList) {
                    if (x == userID) {
                        break;
                    } else {
                        arrayPosition++;
                    }
                }
                // check if the userID is already in the list, if so ask if they want to change or view
                if (idList.contains(userID)) {
                    System.out.println("\nIt looks like they're already in the system. Type 'c' to change their records" +
                            " and 'v' to view them: ");
                    String choice = in.next();

                    // if they choose c, set the position in users to the new values given from studentGrade()
                    if (choice.equalsIgnoreCase("c")) {
                        users.set(arrayPosition, studentGrade(userID));

                    // if they choose v, move on to print out the values
                    } else if (choice.equalsIgnoreCase("v")) {

                    // if they type something that isn't 'c' or 'v', restart loop;
                    } else {
                        System.out.println("That's not a valid option! Taking you back to the beginning.");
                        continue;
                    }

                // otherwise if the ID isn't in the list, call studentGrade function and add it
                } else {
                    users.add(studentGrade(userID));
                    idList.add(userID);

                }
            }

            // print out the information of the current student
            StudentInformation out = users.get(arrayPosition);
            System.out.println("\n" + out.lastName + ", " + out.firstName + "\nStudent ID: " + out.studentID +
                    "\nHomework: " + out.grades[0] + "\nQuizzes: " + out.grades[1] + "\nMidterm: " +
                    out.grades[2] + "\nFinal: " + out.grades[3] + "\n\nTotal Score: " + out.totalScore +
                    "      Grade: " + out.letterGrade);
        }

    }

    private static StudentInformation studentGrade(int studentID) {

        // declare and initialize variables
        String[] sections = {"assignments", "quizzes", "midterm exam", "final exam"};
        Scanner in = new Scanner(System.in);
        StudentInformation currentStudent = new StudentInformation(studentID);

        System.out.print("\nPlease enter the first name of the student: ");
        currentStudent.firstName = in.nextLine();

        System.out.print("\nPlease enter the last name of the student: ");
        currentStudent.lastName = in.nextLine();

        // loop through getting the student's grade for each category listed in sections
        int i = 0;
        for (String x : sections) {

            // loop while keepGoing is true meaning we don't yet have a usable grade value
            boolean keepGoing = true;
            while (keepGoing) {

                // try to get a Double from the user, if not catch, repeat
                try {
                    Double grade;

                    // loop until the grade is between 0 and 100
                    do {
                        System.out.print("\nEnter this student's grade on the " + x + " out of 100: ");
                        grade = in.nextDouble();

                        if (grade >= 0 && grade <= 100) {
                            currentStudent.grades[i] = grade;
                        } else {
                            System.out.println("Make sure the grade is out of 100");
                        }

                    } while (grade < 0 || grade > 100);
                    keepGoing = false;

                } catch (InputMismatchException e) {
                    System.out.println("Make sure you input the grade as a number");
                    in.nextLine();
                    continue;
                }

                i++;
            }
        }

        // calculate score based on weights given
        currentStudent.totalScore = (currentStudent.grades[0] * .5) + (currentStudent.grades[1] * .2) +
                (currentStudent.grades[2] * .1) + (currentStudent.grades[3] * .2);
        Double score = currentStudent.totalScore;

        // calculate grade based on totalScore
        if (score >= 90) {
            currentStudent.letterGrade = 'A';
        } else if (score >= 80) {
            currentStudent.letterGrade = 'B';
        } else if (score >= 70) {
            currentStudent.letterGrade = 'C';
        } else if (score >= 60) {
            currentStudent.letterGrade = 'D';
        } else {
            currentStudent.letterGrade = 'E';
        }

        return currentStudent;

    }

    private static int getID() {
        Scanner in = new Scanner(System.in);
        while (true) {
            // ask for student ID and get the value in a string
            System.out.print("\nPlease enter the student ID number for the student you wish to grade or type 'q' to quit: ");
            String userIn = in.nextLine();
            int id;

            // if they type q, quit
            if (userIn.equalsIgnoreCase("q")) {
                return 0;

                // otherwise, try to change it into an integer, if that fails ask for a valid number
            } else {

                // try to change input to int, if it fails, ask for an int and continue loop
                try {
                    id = Integer.parseInt(userIn);
                    return (id);
                } catch (NumberFormatException e) {
                    System.out.println("The student ID should be in digits");
                }
            }
        }
    }

}




