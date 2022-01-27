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
                        System.out.println("enter the cinema ID: ");
                        int cinemaId = scanner.nextInt();
                        if (CinemaService.validate(cinemaId)){
                            System.out.println("validation successful! ");
                            break;
                        }
                        else System.out.println("cinema ID does not exist! ");
                        break;

                    case 2:
                        scanner.nextLine();
                        System.out.println("enter the cinema ID");
                        cinemaId = scanner.nextInt();
                        if (CinemaService.invalidate(cinemaId)){
                            System.out.println("Invalidation successful! ");
                        }
                        else {
                            System.out.println("cinema ID does not exist! ");
                        }
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
