package console;

import models.Ticket;
import services.CinemaService;
import services.TicketService;
import services.ViewerService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminConsole {

    public static void adminMenu() throws SQLException, ClassNotFoundException, ParseException {

        boolean flag = true;
        while (flag) {
            System.out.println("1-Validate cinema: ");
            System.out.println("2-Invalidate cinema: ");
            System.out.println("0-exit");

            Scanner scanner = new Scanner(System.in);

            try {
                int userEntry = scanner.nextInt();
                switch (userEntry) {
                    case 1:
                        System.out.println("enter the cinema ID");
                        int cinemaId = scanner.nextInt();
                        CinemaService.validate(cinemaId);
                        break;

                    case 2:
                        cinemaId = scanner.nextInt();
                        CinemaService.invalidate(cinemaId);
                    case 0:
                        flag = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number ! ");
            }
        }
    }
}
