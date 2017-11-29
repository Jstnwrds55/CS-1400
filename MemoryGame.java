import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MemoryGame {

    // declare variables
    private String[] colors = {"red", "white", "yellow", "green", "blue"};
    int number = 1; // which number user is on
    private String userGuess; // get users guess in a variable

    // declare components
    private JFrame mainWindow = new JFrame();
    private JLabel askLabel = new JLabel();
    private JTextField colorGuess = new JTextField();

    // constructor
    private MemoryGame() {
        createContents(number);

        mainWindow.setVisible(true);

    }

    private void createContents(int number) {

        // set defaults
        mainWindow = new JFrame();
        mainWindow.setSize(600, 200);
        mainWindow.setTitle("Memory Game");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLayout(new FlowLayout());

        // create components
        askLabel = new JLabel("Enter color number " + number + ": ");
        colorGuess = new JTextField(15);

        // add components
        mainWindow.add(askLabel);
        mainWindow.add(colorGuess);

        // add action listener
        colorGuess.addActionListener(new EnterListener());
    }

    private class EnterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            userGuess = colorGuess.getText();

            // if the color number the user is on is above the length of the colors array, it means the user won!
            if (number >= colors.length) {
                mainWindow.dispose();
                JOptionPane.showMessageDialog(null, "Great job! You have an excellent memory!");
            }

            // otherwise, check to see if the current thing they input matched the current color
            else if (colors[number - 1].equalsIgnoreCase(userGuess)) {
                number++;
                askLabel.setText("Enter color number " + number + ": ");
                colorGuess.setText("");

            // otherwise the user sux and tell 'em so
            } else {
                mainWindow.dispose();
                JOptionPane.showMessageDialog(null, "Awwweee, looks like your memory isn't quite as good as you thought!");
            }
        }
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "How good is your memory?\nTry to memorize this color sequence: \nred white yellow green blue");

        // create an instance of the object
        MemoryGame game = new MemoryGame();

    }
}
