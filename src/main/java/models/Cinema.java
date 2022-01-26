package models;

import java.util.List;

public class Cinema {

    //attributes
    private int id;
    private String username;
    private String name;
    private String  password;
    private boolean validation;
    private List<Ticket> tickets;


    //getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValidation() {
        return validation;
    }




    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }



    //constructor

}
