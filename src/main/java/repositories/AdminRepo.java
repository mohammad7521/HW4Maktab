package repositories;

import connection.ConnectionProvider;
import models.Admin;

import java.sql.*;

public class AdminRepo {


    public AdminRepo() throws SQLException, ClassNotFoundException {
        ConnectionProvider.setConnection();
    }




    //CRUD
    //add admin
    public Admin add (String username,String password) throws SQLException, ClassNotFoundException {

        String insert="INSERT INTO admin (username,password) VALUES(?,?)";

        PreparedStatement preparedStatement= ConnectionProvider.setConnection().prepareStatement(insert);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        preparedStatement.executeUpdate();

        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        preparedStatement.close();

        return admin;

    }





    //remove admin
    public boolean remove(int adminID) throws SQLException, ClassNotFoundException {

        String remove="DELETE FROM admin WHERE id=?";

        PreparedStatement preparedStatement=ConnectionProvider.setConnection().prepareStatement(remove);

        preparedStatement.setInt(1,adminID);

        int removeCheck=preparedStatement.executeUpdate();

        preparedStatement.close();

        return removeCheck >0;
    }

}
