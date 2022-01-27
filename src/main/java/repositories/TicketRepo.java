package repositories;

import connection.ConnectionProvider;
import models.Cinema;
import models.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepo {

    public TicketRepo() throws SQLException, ClassNotFoundException {
        ConnectionProvider.setConnection();
    }



    //add a ticket
    public boolean add(Ticket ticket) {


        String insert="INSERT INTO ticket (ticketDate,startTime,endingtime,movie,cinemaID,quantity,price" +
                ") values(?,?,?,?,?,?,?)";

        int insertCheck=0;
        try {
            PreparedStatement preparedStatement = ConnectionProvider.setConnection().prepareStatement(insert);
            preparedStatement.setDate(1,ticket.getTicketDate());
            preparedStatement.setTime(2,ticket.getStartTime());
            preparedStatement.setTime(3,ticket.getEndingTime());
            preparedStatement.setString(4,ticket.getMovieName());
            preparedStatement.setInt(5,ticket.getCinemaID());
            preparedStatement.setInt(6,ticket.getQuantity());
            preparedStatement.setInt(7,ticket.getPrice());


            insertCheck=preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return insertCheck>0;
    }


    //show all tickets
    public List<Ticket> showAll(){
        String showAll="select * from ticket";

        List<Ticket> ticketsList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(showAll);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Ticket ticket=new Ticket();
                ticket.setId(resultSet.getInt(1));
                ticket.setTicketDate(resultSet.getDate(2));
                ticket.setStartTime(resultSet.getTime(3));
                ticket.setEndingTime(resultSet.getTime(4));
                ticket.setMovieName(resultSet.getString(5));
                ticket.setViewerID(resultSet.getInt(6));
                ticket.setCinemaID(resultSet.getInt(7));
                ticket.setQuantity(resultSet.getInt(7));
                ticket.setPrice(resultSet.getInt(8));

                ticketsList.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ticketsList;
    }




    //reserve a ticket for a viewer
    public boolean reserve(int ticketID,int viewerID,int quantity){
        String reserve="insert into viewer_ticket(ticketID, viewerID, quantity) values (?,?,?)";
        String quantityDeduct="update ticket set quantity=quantity-(?) where id=?";

        int resultCheck1=0;
        int resultCheck=0;

        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(reserve);
            preparedStatement.setInt(1,ticketID);
            preparedStatement.setInt(2,viewerID);
            preparedStatement.setInt(3,quantity);
            resultCheck1=preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1=ConnectionProvider.setConnection().prepareStatement(quantityDeduct);
            preparedStatement1.setInt(1,quantity);
            preparedStatement1.setInt(2,ticketID);
            resultCheck=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultCheck>0 && resultCheck1>0;
    }




    //show tickets of a movie
    public List<Ticket> showAll(String movieName){
        String showAll="select * from ticket where movie=?";

        List<Ticket> ticketsList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(showAll);
            preparedStatement.setString(1,movieName);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                Ticket ticket=new Ticket();
                ticket.setId(resultSet.getInt(1));
                ticket.setTicketDate(resultSet.getDate(2));
                ticket.setStartTime(resultSet.getTime(3));
                ticket.setEndingTime(resultSet.getTime(4));
                ticket.setMovieName(resultSet.getString(5));
                ticket.setViewerID(resultSet.getInt(6));
                ticket.setCinemaID(resultSet.getInt(7));
                ticket.setQuantity(resultSet.getInt(7));
                ticket.setPrice(resultSet.getInt(8));

                ticketsList.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ticketsList;
    }




    //show tickets by id
    public Ticket showAll(int ticketID){
        String showAll="select * from ticket where id=?";

        Ticket ticket=new Ticket();
        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(showAll);
            preparedStatement.setInt(1,ticketID);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                ticket.setId(resultSet.getInt(1));
                ticket.setTicketDate(resultSet.getDate(2));
                ticket.setStartTime(resultSet.getTime(3));
                ticket.setEndingTime(resultSet.getTime(4));
                ticket.setMovieName(resultSet.getString(5));
                ticket.setViewerID(resultSet.getInt(6));
                ticket.setCinemaID(resultSet.getInt(7));
                ticket.setQuantity(resultSet.getInt(7));
                ticket.setPrice(resultSet.getInt(8));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ticket;
    }




    //show tickets of a date
    public List<Ticket> showAll(Date date){
        String showAll="select * from ticket where ticketDate=?";

        List<Ticket> ticketList=new ArrayList<>();
        Ticket ticket=new Ticket();
        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(showAll);
            preparedStatement.setDate(1,date);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                ticket.setId(resultSet.getInt(1));
                ticket.setTicketDate(resultSet.getDate(2));
                ticket.setStartTime(resultSet.getTime(3));
                ticket.setEndingTime(resultSet.getTime(4));
                ticket.setMovieName(resultSet.getString(5));
                ticket.setViewerID(resultSet.getInt(6));
                ticket.setCinemaID(resultSet.getInt(7));
                ticket.setQuantity(resultSet.getInt(7));
                ticket.setPrice(resultSet.getInt(8));
                ticketList.add(ticket);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ticketList;
    }
}
