package service;

import model.Reservation.Reservation;
import model.customer.Customer;
import model.room.IRoom;

import java.util.*;

public class ReservationService {
    private static ReservationService SINGLETON = new ReservationService();
    public static ReservationService getSINGLETON(){
        return SINGLETON;
    }

    //rooms store the roomNumber and rooms that have been reserved
    private Map<String, IRoom> rooms = new HashMap<>();
    //reservations store the customers' email to identify customers, and the reservation a customer made
    private Map<String, Collection<Reservation>> reservations= new HashMap<>();

    //add a room to reserved rooms
    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getARoom(String roomId){
        return rooms.get(roomId);
    }


    public Reservation reserveAroom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        //check whether the customer has reservations
        Collection<Reservation> customerReservations = reservations.get(customer.getEmail());
        if (customerReservations == null){
            customerReservations = new LinkedList<>();
        }
        //renew reservations
        customerReservations.add(reservation);
        reservations.put(customer.getEmail(),customerReservations);

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<Reservation> allReservations = getAllReservations();
        Collection<IRoom> availableRooms = new LinkedList<>();
        //find the reserved rooms between checkInDate and checkOutDate
        for(Reservation reservation : allReservations){
            if (checkInDate.before(reservation.getCheckInDate()) && checkOutDate.after(reservation.getCheckOutDate())){
                availableRooms.add(reservation.getRoom());
            }
        }
        return availableRooms;
    }

    private Collection<Reservation> getAllReservations(){
        Collection<Reservation> allReservations = new LinkedList<>();
        for(Collection<Reservation> reservations: reservations.values()){
            allReservations.addAll(reservations);
        }
        return allReservations;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer){
        return reservations.get(customer.getEmail());
    }

    public void printAllReservation(){
        Collection<Reservation> allReservations = getAllReservations();
        if (allReservations.isEmpty()){
            System.out.println("No reservations found");
        }
        else {
            for (Reservation room: allReservations){
                System.out.println(room + "\n");
            }
        }
    }
}
