package model;

import java.util.Calendar;
import java.util.Scanner;

public class Customer extends Person {
    private String typeGuest;
    private String address;

    public Customer() {
    }

    public Customer(String id, String namePerson, Calendar birthDay, String gender, String identityCard, String phone,
            String email, String typeGuest, String address) {
        super(id, namePerson, birthDay, gender, identityCard, phone, email);
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public String getTypeGuest() {
        return typeGuest;
    }

    public void setTypeGuest(String typeGuest) {
        this.typeGuest = typeGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String typeGuest() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String typeGuest = "";
        do {
            try {
                System.out.println("1.Diamond");
                System.out.println("2.Platium");
                System.out.println("3.Gold");
                System.out.println("4.Silver");
                System.out.println("5.Member");
                System.out.println("Choice(1 -> 5)");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        typeGuest = "Diamond";
                        break;
                    case 2:
                        typeGuest = "Platium";
                        break;
                    case 3:
                        typeGuest = "Gold";
                        break;
                    case 4:
                        typeGuest = "Silver";
                        break;
                    case 5:
                        typeGuest = "Member";
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong,choice again :");
            }

        } while (typeGuest.equals(""));
        return typeGuest;
    }

    @Override
    public String toString() {
        return "Customer :" + super.toString() + "The typeGuest :" + this.typeGuest + "address :" + this.address;
    }

}
