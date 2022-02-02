package model.room;

public class testRoom {
    public static void main(String[] args) {
        RoomType enumeration1 = RoomType.SINGLE;
        Room room1 = new Room("nearSea", 9.9, enumeration1);
        System.out.println(room1.toString());
        /**
         * freeRoom is the child class of Room
         * due to polymorphism, we can set room1 as a type of freeRoom
         */
        room1 = new freeRoom("nearSea", enumeration1);
        System.out.println(room1.toString());
    }
}
