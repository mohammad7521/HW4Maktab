package repositories;
import connection.ConnectionProvider;
import models.Admin;
import models.Cinema;
import models.Ticket;
import models.Viewer;
import org.postgresql.util.PSQLException;

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
    public boolean add(Viewer viewer) {

        int insertCheck=0;
        String insert="INSERT INTO viewer (username,password,firstname,lastname) VALUES (?,?,?,?)";

        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = ConnectionProvider.setConnection().prepareStatement(insert);

            preparedStatement.setString(1,viewer.getUsername());
            preparedStatement.setString(2,viewer.getPassword());
            preparedStatement.setString(3,viewer.getFirstName());
            preparedStatement.setString(4,viewer.getLastName());
            insertCheck= preparedStatement.executeUpdate();;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return insertCheck>0;

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



    //show info of a viewer
    public Viewer showInfo(String username){
        String showInfo="select * from viewer where username=?";

        Viewer viewer=new Viewer();
        try {
            PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(showInfo);
            preparedStatement.setString(1,username);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){

                viewer.setId(resultSet.getInt(1));
                viewer.setUsername(resultSet.getString(2));
                viewer.setPassword(resultSet.getString(3));
                viewer.setFirstName(resultSet.getString(4));
                viewer.setLastName(resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return viewer;
    }
}
