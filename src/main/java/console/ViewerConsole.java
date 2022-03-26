package console;

import exceptionHandlers.DuplicateUser;
import exceptionHandlers.NoSuchMovie;
import exceptionHandlers.NotEnoughTicket;
import models.Cinema;
import models.Ticket;
import models.Viewer;
import services.CinemaService;
import services.TicketService;
import services.ViewerService;

import java.sql.Date;
import java.sql.Time;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ViewerConsole {

    public static void viewerLogInMenu() {

        while (true) {
            System.out.println("1-Register: ");
            System.out.println("2-Sign in: ");
            System.out.println("0-exit");

            Scanner scanner = new Scanner(System.in);

            try {
                int userEntry = scanner.nextInt();
                switch (userEntry) {
                    case 1:
                        System.out.println("enter a username: ");
                        String username = scanner.next();
                        System.out.println("enter a password: ");
                        String password = scanner.next();
                        System.out.println("enter your first name: ");
                        String firstName = scanner.next();
                        System.out.println("enter your last name: ");
                        String lastName = scanner.next();
                        try {
                            ViewerService.addNew(username, password, firstName, lastName);
                        } catch (DuplicateUser e) {
                            System.out.println("username already exists! ");
                        }
                        break;
                    case 2:
                        System.out.println("please enter your username: ");
                        username = scanner.next();
                        System.out.println("please enter your password: ");
                        password = scanner.next();
                        if (ViewerService.logIn(username, password)) {
                            System.out.println("log in successful! ");
                            viewerMainMenu(username);
                            break;
                        } else System.out.println("password is wrong! ");
                        break;
                    case 0:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number ! ");
            } catch (NullPointerException e) {
                System.out.println("username does not exist! ");
            }
        }
    }


    //    viewer main menu
    public static void viewerMainMenu(String username) {

        while (true) {

            System.out.println("1-show all tickets: ");
            System.out.println("2-select tickets by movie name: ");
            System.out.println("3-select tickets by date: ");


            Scanner scanner = new Scanner(System.in);

            try {
                Viewer viewer = ViewerService.showInfo(username);
                int userEntry = scanner.nextInt();
                switch (userEntry) {
                    case 1:
                        List<Ticket> ticketList = TicketService.showAll();

                        for (int i = 0; i < ticketList.size(); i++) {
                            System.out.println("ticket #" + i);
                            System.out.println(ticketList.get(i).toString());
                        }
                        System.out.println("select the ticket by id: ");
                        int ticketID = scanner.nextInt();
                        System.out.println("enter amount: ");
                        int quantity = scanner.nextInt();
                        TicketService.reserve(ticketID, viewer.getId(), quantity);
                        System.out.println("tickets bought successfully!");
                        break;

                    case 2:
                        System.out.println("enter the movie name: ");
                        String movieName = scanner.next();
                        ticketList = TicketService.showAll(movieName);

                        for (int i = 0; i < ticketList.size(); i++) {
                            System.out.println("ticket #" + i);
                            System.out.println(ticketList.get(i).toString());
                        }
                        System.out.println("select the ticket by id: ");
                        ticketID = scanner.nextInt();
                        System.out.println("enter amount: ");
                        quantity = scanner.nextInt();
                        TicketService.reserve(ticketID, viewer.getId(), quantity);
                        break;
                    case 3:
                        System.out.println("enter the date: ");
                        Date date = Date.valueOf(scanner.next());
                        ticketList = TicketService.showAll(date);
                        for (int i = 0; i < ticketList.size(); i++) {
                            System.out.println("ticket #" + i);
                            System.out.println(ticketList.get(i).toString());
                        }
                        System.out.println("select the ticket by id: ");
                        ticketID = scanner.nextInt();
                        System.out.println("enter amount: ");
                        quantity = scanner.nextInt();
                        TicketService.reserve(ticketID, viewer.getId(), quantity);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number");
            } catch (NoSuchMovie e) {
                System.out.println("sorry the movie name is not correct or does not exist!");
            } catch (NotEnoughTicket e) {
                System.out.println("sorry there are not enough tickets available! try decreasing the amount of tickets");
            } catch (IllegalArgumentException e) {
                System.out.println("please enter the date in the following format");
                System.out.println("yyy-mm-dd");
            } catch (NullPointerException e){
                System.out.println("ticket does not exist!");
            }
        }
    }
}