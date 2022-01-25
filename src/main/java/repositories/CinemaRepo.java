package repositories;

import connection.ConnectionProvider;
import models.Cinema;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CinemaRepo {

    public CinemaRepo() throws SQLException, ClassNotFoundException {
        ConnectionProvider.setConnection();
    }


    //CRUD



    //add a cinema
    public boolean add(String name,String username,String password)  {

        int insertCheck=0;
        try {
            String insert="insert into cinema(name,username,password) values (?,?,?)";
            PreparedStatement preparedStatement = ConnectionProvider.setConnection().prepareStatement(insert);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);

            insertCheck=preparedStatement.executeUpdate();

            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return insertCheck>0;
    }



    //remove a cinema
    public boolean remove(int cinemaID) throws SQLException, ClassNotFoundException {

        String remove="DELETE FROM cinema WHERE cinemaID=(?)";

        PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(remove);

        preparedStatement.setInt(1,cinemaID);

        int removeCheck=preparedStatement.executeUpdate();

        preparedStatement.close();

        return removeCheck >0;
    }



    //validate
    public boolean validate(int cinemaID) {

        int validationCheck=0;
        String validate="update cinema set validation=true where cinemaID=?";
        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(validate);
            preparedStatement.setInt(1,cinemaID);
            validationCheck=preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return validationCheck>0;
    }



    //invalidate
    public boolean invalidate(int cinemaID) {

        int validationCheck=0;
        String validate="update cinema set validation=false where cinemaID=?";
        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(validate);
            preparedStatement.setInt(1,cinemaID);
            validationCheck=preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return validationCheck>0;
    }



    //show cinema info
    public Cinema showInfo(int cinemaID){

    }
}
