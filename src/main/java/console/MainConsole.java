package console;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainConsole {

    public static void mainMenu() throws SQLException, ClassNotFoundException, ParseException {

        while (true) {
            System.out.println("1-Admin: ");
            System.out.println("2-Viewer: ");
            System.out.println("3-Cinema: ");

            Scanner scanner = new Scanner(System.in);

            try {
                int userSelect = scanner.nextInt();
                switch (userSelect) {
                    case 1:
                        AdminConsole.adminMenu();
                        break;
                    case 2:
                        ViewerConsole.viewerLogInMenu();
                        break;
                    case 3:
                        CinemaConsole.cinemaLogInMenu();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a number!");
            }
        }
    }
}
