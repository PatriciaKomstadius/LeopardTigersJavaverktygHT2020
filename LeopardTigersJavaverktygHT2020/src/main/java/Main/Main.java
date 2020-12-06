package Main;
import UI.UserInput;

public class Main {

    static boolean loop = true;

    public static void main(String[] args) {

        UserInput.menu();

        while (loop) {
            UserInput.menuChoice();
        }

    }
}
