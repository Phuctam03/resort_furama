package model;

import java.util.Scanner;

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

    String freeService() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String freeService = "";
        do {
            try {
                System.out.println("1.Bar");
                System.out.println("2.Service laudry");
                System.out.println("3.Service fitness center");
                System.out.println("4.Service spa");
                System.out.println("5.Room Service");
                System.out.println("Choice(1 ->5) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        freeService = "Bar";
                        break;
                    case 2:
                        freeService = "Service laudry";
                        break;
                    case 3:
                        freeService = "Service fitness center";
                        break;
                    case 4:
                        freeService = "Service spa";
                        break;
                    case 5:
                        freeService = "Room Service";
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Choice wrong,Choice again :");
            }

        } while (freeService.equals(""));
        return freeService;
    }
    @Override
    public String toString() {
        return "Room :" + super.toString() + freeService();
    }

}
