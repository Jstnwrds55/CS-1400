import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class GradeCalculatorUI {


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

        // get student ID and create instance of StudentInformation class object
        JOptionPane.showMessageDialog(null, "Welcome to the grade calculator 9000");

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
                    Object[] options = {"Change", "View"};
                    int choice = JOptionPane.showOptionDialog(null, "It looks like they're " +
                                    "already in the system. Would you like to change or view their records?", "Choose",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    // if they choose c, set the position in users to the new values given from studentGrade()
                    if (choice == 0) {
                        users.set(arrayPosition, studentGrade(userID));

                        // if they choose v, move on to print out the values
                    } else if (choice == 1) {

                        // if they type something that isn't 'c' or 'v', restart loop;
                    } else {
                        JOptionPane.showConfirmDialog(null, "That's not a valid option! " +
                                "Taking you back to the beginning.");
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
            Object[] options = {"Next Student", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "\n" + out.lastName + ", " + out.firstName
                            + "\nStudent ID: " + out.studentID + "\nHomework: " + out.grades[0] + "\nQuizzes: " + out.grades[1]
                            + "\nMidterm: " + out.grades[2] + "\nFinal: " + out.grades[3] + "\n\nTotal Score: " + out.totalScore
                            + "      Grade: " + out.letterGrade, "Grades", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == 1) {
                break;
            }
        }

    }

    private static StudentInformation studentGrade(int studentID) {

        // declare and initialize variables
        String[] sections = {"assignments", "quizzes", "midterm exam", "final exam"};
        StudentInformation currentStudent = new StudentInformation(studentID);

        currentStudent.firstName = JOptionPane.showInputDialog("Please enter the first name of the student.");

        currentStudent.lastName = JOptionPane.showInputDialog("Please enter the last name of the student.");

        // loop through getting the student's grade for each category listed in sections
        int i = 0;
        for (String x : sections) {
            Double gradeNumber = -1.0;
            // loop while keepGoing is true meaning we don't yet have a usable grade value
            while (gradeNumber == -1.0) {

                // try to get a Double from the user, if not catch, repeat
                try {
                    String grade;
                    grade = JOptionPane.showInputDialog("Enter this student's grade on the " + x + " out of 100.");
                    gradeNumber = Double.parseDouble(grade);

                    // loop until the grade is between 0 and 100
                    if (gradeNumber >= 0 && gradeNumber <= 150) {
                        currentStudent.grades[i] = gradeNumber;
                    } else {
                        gradeNumber = -1.0;
                        JOptionPane.showMessageDialog(null, "Make sure the grade is out of 100");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Make sure you input the grade as a number!");
                }
            }
            i++;
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
        while (true) {
            // ask for student ID and get the value in a string
            String userIn = JOptionPane.showInputDialog("Please enter the student ID number for the student you " +
                    "wish to grade.");
            int id;

            // try to change input to int, if it fails, ask for an int and continue loop
            try {
                id = Integer.parseInt(userIn);
                return (id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Make sure it's in digit form");
            }
        }
    }

}




