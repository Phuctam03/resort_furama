package model;


public class Villa extends Facility {
    private String roomRank;
    private double areaPool;
    private int floor;

    public Villa() {
    }

    public Villa(String id, String nameService, double useArea, double priceHire, int numberPeople, String typeRental,
            String roomRank, double areaPool, int floor) {
        super(id, nameService, useArea, priceHire, numberPeople, typeRental);
        this.roomRank = roomRank;
        this.areaPool = areaPool;
        this.floor = floor;
    }

    public String getRoomRank() {
        return roomRank;
    }

    public void setRoomRank(String roomRank) {
        this.roomRank = roomRank;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    @Override
    public String toString() {
        return "Villa :" + super.toString() + "roomrRank" + this.roomRank + "The area pool :" + this.areaPool
                + "The floor :"
                + this.floor;
    }

}
