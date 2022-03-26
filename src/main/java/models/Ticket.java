package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Ticket {

    //attributes
    private int id;
    private Date ticketDate;
    private Time startTime;
    private Time endingTime;
    private String movieName;
    private Cinema cinema=new Cinema();
    int quantity;
    int price;
    private Viewer viewer =new Viewer();



    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Time endingTime) {
        this.endingTime = endingTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getCinemaID(){
        return  cinema.getId();
    }

    public void setCinemaID(int cinemaID){
        this.cinema.setId(cinemaID);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public int getViewerID(){
        return  viewer.getId();
    }

    public void setViewerID(int viewerID){
        viewer.setId(viewerID);
    }

    @Override
    public String toString() {
        return  "id: " + id +
                "\nticketDate: " + ticketDate +
                "\nstartTime: " + startTime +
                "\nendingTime: " + endingTime +
                "\nmovieName: " + movieName+
                "\ncinema ID: " + cinema.getId() +
                "\nquantity: " + quantity +
                "\nprice: " + price +
                '}';
    }
}
