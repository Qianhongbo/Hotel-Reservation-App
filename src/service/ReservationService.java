package service;

import model.Reservation.Reservation;
import model.customer.Customer;
import model.room.IRoom;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {
    private static ReservationService SINGLETON = new ReservationService();
    //rooms store the roomNumber and rooms that have been reserved
    private Map<String, IRoom> rooms = new HashMap<>();
    //reservations store the customers' email to identify customers, and the reservation a customer made
    private Map<String, Collection<Reservation>> reservations= new HashMap<>();

    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        return rooms.get(roomId);
    }

    public Reservation reserveAroom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        Collection<>
        reservations.put();
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

    }

    public Collection<Reservation> getCustomersReservation(Customer customer){

    }

    public void printAllReservation(){

    }
}
