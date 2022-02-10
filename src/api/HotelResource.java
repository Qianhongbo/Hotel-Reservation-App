package api;

import model.Reservation.Reservation;
import model.customer.Customer;
import model.room.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    public static Customer getCustomer(String email) {
        CustomerService customerService =  CustomerService.getSINGLETON();
        return customerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        CustomerService customerService =  CustomerService.getSINGLETON();
        customerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomNumber) {
        ReservationService reservationService = ReservationService.getSINGLETON();
        return reservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        ReservationService reservationService = ReservationService.getSINGLETON();
        return reservationService.reserveAroom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail) {
        ReservationService reservationService = ReservationService.getSINGLETON();
        return reservationService.getCustomersReservation(getCustomer(customerEmail));
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkout) {
        ReservationService reservationService = ReservationService.getSINGLETON();
        return reservationService.findRooms(checkIn, checkout);
    }

}
