import org.ripadbaisor.elements.Manager;
import org.ripadbaisor.util.Menu;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();

        while (true) {
            String option = Menu.showMenu();
            Menu.performAction(option, manager);
        }
    }
}