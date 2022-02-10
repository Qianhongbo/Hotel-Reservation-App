package menu;

import api.AdminResource;
import model.customer.Customer;
import model.room.IRoom;
import model.room.Room;
import model.room.RoomType;

import java.util.*;

public class AdminMenu {

    public static void showAdminMenu(Scanner scanner) {
        flag = true;
        // Get the user input number
        while (flag) {
            System.out.println(adminMenuText);
            while (scanner.hasNext()) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Please input 1 to 5...");
                    scanner.next();
                }
                int temp = scanner.nextInt();
                if (temp >= 1 && temp <= 5) {
                    handleUserInput(scanner, temp);
                    break;
                }
                System.out.println("Please input 1 to 5...");
            }
        }
    }

    protected static void handleUserInput(Scanner scanner ,int userInput) {
        switch (userInput) {
            case 1 -> seeAllCustomers();                            // 1. See all Customers
            case 2 -> seeAllRooms();                                // 2. See all Rooms
            case 3 -> AdminResource.displayAllReservations();       // 3. See all Reservations
            case 4 -> addARoom(scanner);                            // 4. Add a Room
            case 5 -> flag = false;                                 // 5. Return to main menu
            default -> throw new IllegalStateException("Unexpected value: " + userInput);
        }
    }

    private static void seeAllCustomers() {
        Collection<Customer> customers = AdminResource.getAllCustomers();
        if (!customers.isEmpty()) {
            for (Customer customer: customers) {
                System.out.println(customer);
            }
            System.out.println();
        } else {
            System.out.println("No customers have been added." + "\n");
        }
    }

    private static void seeAllRooms() {
        Collection<IRoom> rooms = AdminResource.getAllRooms();
        if (!rooms.isEmpty()) {
            for (IRoom room: rooms) {
                System.out.println(room);
            }
            System.out.println();
        } else {
            System.out.println("No rooms have been added." + "\n");
        }
    }

    private static void addARoom(Scanner scanner) {
        List<IRoom> rooms = new ArrayList<>();
        RoomType roomType = RoomType.SINGLE;

        String userChoice = "y";
        while (userChoice.equals("y")) {
            System.out.println("Enter room number");
            String roomNumber = scanner.next().trim();

            System.out.println("Enter price per night");
            while (!scanner.hasNextDouble()) {
                System.out.println("Please input double...");
                scanner.next();
            }
            double price = scanner.nextDouble();

            System.out.println("Enter room type: 1 for SINGLE bed,  2 for DOUBLE bed");
            while (scanner.hasNext()) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Please input 1 or 2...");
                    scanner.next();
                }
                int temp = scanner.nextInt();
                if (temp == 1 || temp == 2) {
                    roomType = temp == 1 ? RoomType.SINGLE : RoomType.DOUBLE;
                    break;
                }
                System.out.println("Please input 1 or 2...");
            }

            Room room = new Room(roomNumber, price, roomType);
            System.out.println("Room created: " + "Room-Num: " + roomNumber + " |"
                    + "Room-Price: " + price + " |"
                    + "Room-Type: " + roomType);
            rooms.add(room);

            System.out.println("Add more rooms? y/n");
            userChoice = scanner.next();
        }
        AdminResource.addRoom(rooms);
    }

    protected static boolean flag = true;
    protected static final String adminMenuText = """
                Admin Menu
                -----------------------------------------------
                1. See all Customers
                2. See all Rooms
                3. See all Reservations
                4. Add a Room
                5. Back to Main Menu
                -----------------------------------------------
                Please select a number for the admin option""";

}
