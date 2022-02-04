package service;

import model.customer.Customer;
import model.room.Room;
import model.room.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testService{
    public static void main(String[] args) throws ParseException {
        String checkIn = "26-09-1980";
        String checkOut = "28-09-1980";
        String anotherDateStr1 = "21-09-1980";
        String anotherDateStr2 = "30-09-1980";
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //Parsing the given String to Date object
        Date checkInDate = formatter.parse(checkIn);
        Date checkOutDate = formatter.parse(checkOut);
        Date anotherDate1 = formatter.parse(anotherDateStr1);
        Date anotherDate2 = formatter.parse(anotherDateStr2);
//
        ReservationService ReservationService = service.ReservationService.getInstance();
        Customer first = new Customer("Lindong", "Ye","lye@ucsd.edu");
        RoomType enumeration1 = RoomType.DOUBLE;
        Room firstRoom = new Room("311", 951.50, enumeration1);
        ReservationService.reserveAroom(first, firstRoom, checkInDate, checkOutDate);

        ReservationService.printAllReservation();
        System.out.println(ReservationService.findRooms(anotherDate1,anotherDate2));

        System.out.println(ReservationService.getCustomersReservation(first));

        Room secondRoom = new Room("512", 30.0, enumeration1 );
        ReservationService.reserveAroom(first,secondRoom,anotherDate1,anotherDate2);
        ReservationService.printAllReservation();
        System.out.println(ReservationService.getCustomersReservation(first));

    }
}
