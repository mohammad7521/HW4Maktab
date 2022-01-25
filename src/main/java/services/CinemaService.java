package services;

import models.Cinema;
import repositories.CinemaRepo;

import java.sql.SQLException;

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

        if (cinemaRepo.add(name, username, password)) {
            System.out.println("sign up successful! ");
        }
        else System.out.println("something went wrong please try again! ");
    }


    //validate cinema
    public static boolean validate(int cinemaID){

        return cinemaRepo.validate(cinemaID);
    }



    //invalidate cinema
    public static boolean invalidate(int cinemaID){

        return  cinemaRepo.invalidate(cinemaID);
    }



    //show info of a cinema user
    public Cinema showInfo(int cinemaID){

    }

}
