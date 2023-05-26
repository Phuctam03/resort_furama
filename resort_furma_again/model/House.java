package model;


public class House extends Facility {
    private String typeRoom;
    private int floor;

    public House() {
    }

    public House(String id, String nameService, double useArea, double priceHire, int numberPeople, String typeRental,
            String typeRoom, int floor) {
        super(id, nameService, useArea, priceHire, numberPeople, typeRental);
        this.typeRoom = typeRoom;
        this.floor = floor;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House :" + super.toString() + "the typeRoom :" + this.typeRoom + "the floor :" + this.floor;
    }
}