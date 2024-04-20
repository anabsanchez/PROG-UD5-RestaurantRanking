import javax.swing.JOptionPane;

import org.ripadbaisor.elements.Manager;
import org.ripadbaisor.util.Menu;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();

        while (true) {
            try {
                String option = Menu.showMenu();
                Menu.performAction(option, manager);
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}