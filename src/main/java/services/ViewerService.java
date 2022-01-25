package services;

import repositories.ViewerRepo;

import java.sql.SQLException;

public class ViewerService {

    public static ViewerRepo viewerRepo;

    {
        try {
            viewerRepo = new ViewerRepo();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //add new viewer
    public static boolean addNew(String username,String password,
    String firstName,String lastname) throws SQLException, ClassNotFoundException {

        return  viewerRepo.add(username,password,firstName,lastname);
    }
}


