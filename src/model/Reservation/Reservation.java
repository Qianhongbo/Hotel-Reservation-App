package model.Reservation;

import model.customer.Customer;
import model.room.IRoom;

import java.util.Date;
//reservation contains info about customers and rooms
public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return  customer + "\n" +
                room + "\n" +
                "checkInDate: " + checkInDate + "\n" +
                "checkOutDate: " + checkOutDate + "\n";
    }
}
