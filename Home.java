import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home {

    private JFrame homeScreen;
    private JLabel lblName;
    private JTextField txtName;
    private JButton okBtn;

    private MyButtonListener listen1 = new MyButtonListener();

    public Home () {
        homeScreen = new JFrame ();

        homeScreen.setSize(400,200);
        homeScreen.setTitle("GUI Fun!");
        homeScreen.setDefaultCloseOperation(homeScreen.EXIT_ON_CLOSE);
        homeScreen.setLayout(new FlowLayout());

        lblName = new JLabel("Enter your name:");
        txtName = new JTextField(20);
        okBtn = new JButton("OK");

        homeScreen.add(lblName);
        homeScreen.add(txtName);
        homeScreen.add(okBtn);

        okBtn.addActionListener(listen1);
        txtName.addActionListener(listen1);

        homeScreen.setVisible(true);
    }

    private class MyButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            txtName.setBackground(Color.blue);

            homeScreen.setVisible(true);
        }

    }

}
