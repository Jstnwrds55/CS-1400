import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Compatibility {

    // declare components
    private JFrame mainWindow;
    private JLabel labelName1;
    private JLabel labelName2;
    private JLabel labelResults;
    private JTextField textName1;
    private JTextField textName2;
    private JButton checkButton;

    // constructor
    public Compatibility () {
        createContents();

        mainWindow.setVisible(true);
    }

    private void createContents () {
        mainWindow = new JFrame(); // create frame

        // set defaults
        mainWindow.setSize(600, 100);
        mainWindow.setTitle("Check Your Mate");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setLayout(new FlowLayout());

        // create components
        labelName1 = new JLabel("Enter name #1: ");
        textName1 = new JTextField(15);
        labelName2 = new JLabel("Enter name #2: ");
        textName2 = new JTextField(15);
        checkButton = new JButton("Check Compatibility");
        labelResults = new JLabel(" ");

        // add components
        mainWindow.add(labelName1);
        mainWindow.add(textName1);
        mainWindow.add(labelName2);
        mainWindow.add(textName2);
        mainWindow.add(checkButton);
        mainWindow.add(labelResults);

        // attach action listener
        checkButton.addActionListener(new CheckListener());

    }

    private class CheckListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("testing");
        }
    }

    public static void main(String[] args) {
        Compatibility c = new Compatibility();
    }

}


