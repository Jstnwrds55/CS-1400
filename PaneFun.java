import javax.swing.*;
import java.awt.*;

public class PaneFun {
    public static void main(String[] args) {

        JFrame homeScreen = new JFrame();

        homeScreen.setSize(400, 200);
        homeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeScreen.setTitle("New Frame");
        homeScreen.setLayout(new FlowLayout());


        JLabel name = new JLabel("Enter your name: ");
        JTextField txtName = new JTextField(20);
        JButton okBtn = new JButton("OK");

        homeScreen.add(name);
        homeScreen.add(txtName);
        homeScreen.add(okBtn);


        homeScreen.setVisible(true);

    }
}
