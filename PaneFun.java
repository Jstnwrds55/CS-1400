import jdk.nashorn.internal.scripts.JO;

import javax.swing.JOptionPane;

public class PaneFun {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hey there");
        String name = JOptionPane.showInputDialog(null, "Who are you?");
        JOptionPane.showMessageDialog(null, "Hi " + name + ".");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "How old are you?"));
        JOptionPane.showMessageDialog(null, "I am " + (18-age) + " years older than you");
        JOptionPane.showConfirmDialog(null, "Are you happy with your life?");
    }
}
