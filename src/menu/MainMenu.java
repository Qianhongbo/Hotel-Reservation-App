package menu;

import api.AdminResource;
import api.HotelResource;
import model.Reservation.Reservation;
import model.customer.Customer;
import model.room.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    public static void showMainMenu() {
        // Get the user input number
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                System.out.println(mainMenuText);
                while (scanner.hasNext()) {
                    while (!scanner.hasNextInt()) {
                        System.out.println("Please input 1 to 5...");
                        scanner.next();
                    }
                    int temp = scanner.nextInt();
                    if (temp >= 1 && temp <= 5) {
                        scanner.nextLine();
                        handleUserInput(scanner, temp);
                        break;
                    }
                    System.out.println("Please input 1 to 5...");
                }
            }
        } catch (Exception ex) {
            ex.getLocalizedMessage();
        }
    }

    protected static void handleUserInput(Scanner scanner, int userInput) {
        switch (userInput) {
            case 1 -> findAndReserveARoom(scanner);   // 1. Find and Reserve a room
            case 2 -> seeMyReservations(scanner);   // 2. See my reservations
            case 3 -> createAnAccount(scanner);                 // 3. Create an account
            case 4 -> AdminMenu.showAdminMenu(scanner);
            case 5 -> flag = false;
            default -> throw new IllegalStateException("Unexpected value: " + userInput);
        }
    }

    private static void findAndReserveARoom(Scanner scanner) {
        SimpleDateFormat bookingDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Enter your Check-In Date in the Format mm/dd/yyyy"  + " E.g.: 12/10/2022");
        Date checkInDate = null;
        try {
            checkInDate = bookingDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Enter your Check-Out Date in the Format dd/mm/yyyy" + " E.g.: 12/31/2022");
        Date checkOutDate = null;
        try {
            checkOutDate = bookingDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("These are all available rooms!");
        Collection<IRoom> availableRooms = HotelResource.findARoom(checkInDate, checkOutDate);
        for (IRoom room: availableRooms) {
            System.out.println(room);
        }

        String email = "name@domain.com";
        if (!availableRooms.isEmpty()) {
            System.out.println("Do you have an account? Select (y/n)");
            char userChoice = scanner.nextLine().trim().charAt(0);
            if (userChoice == 'y') {
                System.out.println("Enter your Email: name@domain.com");
                String tempEmail = scanner.nextLine();
                Customer customer = AdminResource.getCustomer(tempEmail);
                if (customer == null) {
                    email = createAnAccount(scanner);
                } else {
                    email = tempEmail;
                }
            } else if (userChoice == 'n') {
                email = createAnAccount(scanner);
            } else {
                System.out.println("Illegal input! Please input y/n.");
                return;
            }
            System.out.println("What room number would you like to reserve?");
            while (!scanner.hasNextInt()) {
                System.out.println("Please input a room number.");
                scanner.next();
            }
            IRoom theRoom = HotelResource.getRoom(scanner.nextLine());
            Reservation theReservation =  HotelResource.bookARoom(email, theRoom, checkInDate, checkOutDate);
            System.out.println(theReservation);
        } else {
            System.out.println("No rooms available." + "\n");
        }
    }

    private static void seeMyReservations(Scanner scanner) {
        System.out.println("Enter your Email:");
        String email = scanner.nextLine();
        if (HotelResource.getCustomer(email) != null) {
            for (Reservation reservation: HotelResource.getCustomerReservations(email)) {
                System.out.println(reservation);
            }
        } else {
            System.out.println("Can't find any reservations!" + "\n");
        }
    }

    private static String createAnAccount(Scanner scanner) {
        System.out.println("Enter your First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter your Email: name@domain.com");
        String email = scanner.nextLine();

        HotelResource.createACustomer(email, firstName, lastName);
        System.out.println();
        System.out.println("Name: " + firstName + " " + lastName + ", Email: " + email);
        System.out.println();
        return email;
    }

    protected static boolean flag = true;
    protected static final String mainMenuText = """
                Welcome to the Hotel Reservation Application
                -----------------------------------------------
                1. Find and Reserve a room
                2. See my reservations
                3. Create an account
                4. Admin
                5. Exit
                -----------------------------------------------
                Please select a number for the menu option""";

}
