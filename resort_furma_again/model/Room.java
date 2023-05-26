package model;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String id, String nameService, double useArea, double priceHire, int numberPeople, String typeRental,
            String freeService) {
        super(id, nameService, useArea, priceHire, numberPeople, typeRental);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room :" + super.toString() + this.freeService;
    }

}
