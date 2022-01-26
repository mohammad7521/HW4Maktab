package services;

import exceptionHandlers.DuplicateUser;
import models.Cinema;
import models.Viewer;
import repositories.ViewerRepo;

import java.sql.SQLException;

public class ViewerService {

    public static ViewerRepo viewerRepo;

    static {
        try {
            viewerRepo = new ViewerRepo();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //add new viewer
    public static void addNew(String username,String password,
    String firstName,String lastname) {

        Viewer viewer=new Viewer();

        try {
            if (ViewerService.showInfo(username).getUsername().equals(username)) {
                throw new DuplicateUser("username already exists");
//                System.out.println("username already exists!");
            }
        }catch (NullPointerException e){

            System.out.println("username is free!");
            System.out.println();
        }
        viewer.setUsername(username);
        viewer.setPassword(password);
        viewer.setFirstName(firstName);
        viewer.setLastName(lastname);
        viewerRepo.add(viewer);
        System.out.println("user created successfully");
    }


    //show info of a viewer
    public static Viewer showInfo(String username){

        return viewerRepo.showInfo(username);
    }




    //viewer logIn
    public static boolean logIn(String username,String password){

        boolean logInCheck=false;
        Viewer viewer=new Viewer();

        viewer.setUsername(ViewerService.showInfo(username).getUsername());
        viewer.setPassword(ViewerService.showInfo(username).getPassword());

        if (viewer.getUsername().equals(username)) {
            if (viewer.getPassword().equals(password)) {
                logInCheck = true;
            }
        } else logInCheck = false;

        return logInCheck;
    }

}


