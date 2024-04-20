import org.ripadbaisor.elements.Manager;
import org.ripadbaisor.util.Menu;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        Menu menu = new Menu();

        while (true) {
            String option = Menu.showMenu();
            menu.performAction(option, manager);
        }
    }
}