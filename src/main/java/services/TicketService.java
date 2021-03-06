package services;

import exceptionHandlers.NoSuchMovie;
import exceptionHandlers.NotEnoughTicket;
import models.Cinema;
import models.Ticket;
import models.Viewer;
import repositories.TicketRepo;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class TicketService {

    private static TicketRepo ticketRepo;

    static {
        try {
            ticketRepo = new TicketRepo();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //add new ticket
    public static boolean addNew(Date ticketDate, Time startTime, Time endingTime, String movieName, int cinemaID, int quantity,
                                 int price) {
        Ticket ticket=new Ticket();
        ticket.setTicketDate(ticketDate);
        ticket.setStartTime(startTime);
        ticket.setEndingTime(endingTime);
        ticket.setMovieName(movieName);
        ticket.setCinemaID(cinemaID);
        ticket.setQuantity(quantity);
        ticket.setPrice(price);

        return ticketRepo.add(ticket);
    }



    //show all tickets
    public static List<Ticket> showAll(){
        return ticketRepo.showAll();
    }




    //reserve a ticket based on ticketID
    public static void reserve(int ticketID,int viewerID,int quantity){

        Ticket ticket=showInfo(ticketID);
        if (ticket.getMovieName()==null || ticket==null){
            throw new NullPointerException();
        }
        else {
            if (ticket.getQuantity() < quantity) {
                throw new NotEnoughTicket();
            }
            else     ticketRepo.reserve(ticketID, viewerID, quantity);
        }
    }



    //show tickets of a movie
    public static List<Ticket> showAll(String movieName){

        List<Ticket>ticketList=showAll();

        for (Ticket t:ticketList){
            if (t.getMovieName().equals(movieName));
            else throw new NoSuchMovie();
        }
        return ticketRepo.showAll(movieName);
    }



    //show info of a ticket
    public static Ticket showInfo(int ticketID){

        return ticketRepo.showAll(ticketID);
    }




    //show tickets of a date
    public static List<Ticket> showAll(Date date){

        return ticketRepo.showAll(date);
    }


}
