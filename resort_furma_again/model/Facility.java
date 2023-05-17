package model;

import java.util.Scanner;

public abstract class Facility {
    protected String id;
    protected String nameService;
    protected double useArea;
    protected double priceHire;
    protected int numberPeople;
    protected String typeRental;

    public Facility() {
    }

    public Facility(String id, String nameService, double useArea, double priceHire, int numberPeople,
            String typeRental) {
        this.id = id;
        this.nameService = nameService;
        this.useArea = useArea;
        this.priceHire = priceHire;
        this.numberPeople = numberPeople;
        this.typeRental = typeRental;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getPriceHire() {
        return priceHire;
    }

    public void setPriceHire(double priceHire) {
        this.priceHire = priceHire;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    protected String typeRental() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String rental = "";
        do {
            try {
                System.out.println("1.Year");
                System.out.println("2.Month");
                System.out.println("3.Day");
                System.out.println("4.Hour");
                System.out.println();
                System.out.println("Choice (1 -> 4) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        rental = "Year";
                        break;
                    case 2:
                        rental = "Month";
                        break;
                    case 3:
                        rental = "Day";
                        break;
                    case 4:
                        rental = "Hour";
                        break;

                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("choice wrong, choice agian");
            }
        } while (rental.equals(""));

        return rental;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nameService=" + nameService + ", useArea=" + useArea + ", priceHire="
                + priceHire + ", numberPeople=" + numberPeople + ", typeRental=" + typeRental() + "]";
    }

}
