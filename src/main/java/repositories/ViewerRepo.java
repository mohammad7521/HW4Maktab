package repositories;
import connection.ConnectionProvider;
import models.Admin;
import models.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewerRepo {


    public ViewerRepo() throws SQLException, ClassNotFoundException {
        ConnectionProvider.setConnection();

    }

    //CRUD


    //create new viewer
    public boolean add(String username,String password,String firstName,String lastName) throws SQLException, ClassNotFoundException {

        String insert="INSERT INTO viewer (username,password,firstname,lastname) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(insert);

        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,firstName);
        preparedStatement.setString(4,lastName);

        return  preparedStatement.executeUpdate()>0;

    }



    //remove a viewer
    public boolean remove(int viewerID) throws SQLException, ClassNotFoundException {
        String remove="DELETE FROM viewer WHERE viewerID=?";

        PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(remove);

        preparedStatement.setInt(1,viewerID);

        int removeCheck=preparedStatement.executeUpdate();

        preparedStatement.close();

        return removeCheck >0;
    }




    //update info of a client
    public boolean update(int clientID,String firstName,String lastName,String address) throws SQLException, ClassNotFoundException {
        String update="UPDATE client SET firstName=?,lastName=?,address=? WHERE clientID=?";

        PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(update);

        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,address);
        preparedStatement.setInt(4,clientID);

        int updateCheck=preparedStatement.executeUpdate();

        preparedStatement.close();

        return updateCheck >0;
    }



    //
}
