package model;

import java.util.Scanner;

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

    String typeRoom() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String typeRoom = "";
        do {
            try {
                System.out.println("1.Room A");
                System.out.println("2.Room B");
                System.out.println("3.Room C");
                System.out.println("4.Room D");
                System.out.println("Choice(1 -> 4)");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        typeRoom = "Room A";
                        break;
                    case 2:
                        typeRoom = "Room B";
                        break;
                    case 3:
                        typeRoom = "Room C";
                        break;
                    case 4:
                        typeRoom = "Room D";
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong,Choice again");
            }

        } while (typeRoom.equals(""));

        return typeRoom;
    }

    @Override
    public String toString() {
        return "Villa :" + super.toString() + "roomrRank" + typeRoom() + "The area pool :" + this.areaPool
                + "The floor :"
                + this.floor;
    }

}
