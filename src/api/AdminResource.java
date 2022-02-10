package api;

import model.customer.Customer;
import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    public static Customer getCustomer(String email) {
        CustomerService customerService =  CustomerService.getSINGLETON();
        return customerService.getCustomer(email);
    }

    public static void addRoom(List<IRoom> rooms) {
        ReservationService reservationService = ReservationService.getSINGLETON();
        for (IRoom aRoom: rooms) {
            reservationService.addRoom(aRoom);
        }
    }

    public static Collection<IRoom> getAllRooms() {
        ReservationService reservationService = ReservationService.getSINGLETON();
        return reservationService.getAllRooms();
    }

    public static Collection<Customer> getAllCustomers() {
        CustomerService customerService =  CustomerService.getSINGLETON();
        return customerService.getAllCustomers();
    }

    public static void displayAllReservations() {
        ReservationService reservationService = ReservationService.getSINGLETON();
        reservationService.printAllReservation();
    }

}
