package model.room;

public class freeRoom extends Room{
    public freeRoom(String roomNumber, RoomType enumeration){
        super(roomNumber, 0.0, enumeration);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
