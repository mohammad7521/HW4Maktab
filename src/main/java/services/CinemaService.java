package services;

import exceptionHandlers.DuplicateUser;
import models.Cinema;
import models.Ticket;
import repositories.CinemaRepo;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class CinemaService {

    private static CinemaRepo cinemaRepo;

    static {
        try {
            cinemaRepo = new CinemaRepo();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //add new cinema
    public static void addNew(String name,String username,String password) {

        Cinema cinema=new Cinema();

        try {
            if (CinemaService.showInfo(username).getUsername().equals(username)) {
                throw new DuplicateUser("username already exists");
            }
        }catch (NullPointerException e){

            System.out.println("username is free!");
            System.out.println();
        }
        cinema.setUsername(username);
        cinema.setPassword(password);
        cinema.setName(name);
        cinemaRepo.add(cinema);
        System.out.println("user created successfully");
    }


    //validate cinema
    public static boolean validate(int cinemaID){

        return cinemaRepo.validate(cinemaID);
    }



    //invalidate cinema
    public static boolean invalidate(int cinemaID){

        return  cinemaRepo.invalidate(cinemaID);
    }



    //show info of a cinema
    public static Cinema showInfo(String username){
        return cinemaRepo.showInfo(username);
    }




    //cinema logIn
    public static boolean logIn(String username,String password){

        boolean logInCheck=false;
        Cinema cinema=new Cinema();

            cinema.setUsername(CinemaService.showInfo(username).getUsername());
            cinema.setPassword(CinemaService.showInfo(username).getPassword());

            if (cinema.getUsername().equals(username)) {
                if (cinema.getPassword().equals(password)) {
                    logInCheck = true;
                }
            } else logInCheck = false;

        return logInCheck;
    }




    //generate tickets
    public static boolean generateTickets(String username, Date ticketDate, Time startTime, Time endingTime, String movieName, int cinemaID, int quantity,
                                          int price){

        boolean generateCheck=false;
        Cinema cinema=CinemaService.showInfo(username);

        if (cinema.isValidation()){

            TicketService.addNew(ticketDate,startTime,endingTime,movieName,cinemaID,quantity,
                    price);
            generateCheck=true;
        }
        return generateCheck;
    }
}
