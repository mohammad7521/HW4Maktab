package services;

import models.Cinema;
import repositories.TicketRepo;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class TicketService {

    private static TicketRepo ticketRepo;




    //add new ticket
    public static boolean addNew(Date ticketDate, Time startTime, Time endingTime, String movieName, int cinemaID, int quantity,
                                 int price) throws SQLException, ClassNotFoundException {

        return ticketRepo.add(ticketDate,startTime,endingTime,movieName,
                cinemaID,quantity,price);
    }


}
