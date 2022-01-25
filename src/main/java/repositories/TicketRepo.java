package repositories;

import connection.ConnectionProvider;
import models.Cinema;

import java.sql.*;

public class TicketRepo {

    public TicketRepo() throws SQLException, ClassNotFoundException {
        ConnectionProvider.setConnection();
    }



    //add a ticket
    public boolean add(Date ticketDate, Time startTime,Time endingTime,String movieName,int cinemaID,int quantity,
    int price) throws SQLException, ClassNotFoundException {

        String insert="INSERT INTO ticket (ticketDate,startTime,endingtime,movie,cinemaID,quantity,price" +
                ") values(?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement= ConnectionProvider.setConnection().prepareStatement(insert);

        preparedStatement.setDate(1,ticketDate);
        preparedStatement.setTime(2,startTime);
        preparedStatement.setTime(3,endingTime);
        preparedStatement.setString(4,movieName);
        preparedStatement.setInt(5,cinemaID);
        preparedStatement.setInt(6,quantity);
        preparedStatement.setInt(7,price);


        int insertCheck=preparedStatement.executeUpdate();

        preparedStatement.close();

        return insertCheck>0;
    }
}
