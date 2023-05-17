package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Employee extends Person {
    private String degree;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String id, String namePerson, LocalDate birthDay, String gender, String identityCard, String phone,
            String email, String degree, String position, double salary) {
        super(id, namePerson, birthDay, gender, identityCard, phone, email);
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    String degree() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String degree = "";
        do {
            try {
                System.out.println("1.Intermediate");
                System.out.println("2.College");
                System.out.println("3.University");
                System.out.println("4.After university");
                System.out.println("Choice (1 -> 4 )");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        degree = "Intermediate ";
                        break;
                    case 2:
                        degree = "College";
                        break;
                    case 3:
                        degree = "University";
                        break;
                    case 4:
                        degree = "After university";
                        break;

                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
            }

        } while (degree.equals(""));
        return degree;
    }

    String position() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String poisition = "";
        do {
            try {
                System.out.println("1.Reception");
                System.out.println("2.Waiter");
                System.out.println("3.Expert");
                System.out.println("4.supervise");
                System.out.println("5.Managements");
                System.out.println("6.CEO");
                System.out.println("Choice (1->6)");
                luachon = Integer.parseInt(sc.nextLine());

                switch (luachon) {
                    case 1:
                        poisition = "Reception";

                        break;
                    case 2:
                        poisition = "Waiter";
                    case 3:
                        poisition = "Expert";
                        break;
                    case 4:
                        poisition = "supervise";
                        break;
                    case 5:
                        poisition = "Managements";
                        break;
                    case 6:
                        poisition = "CEO";
                        break;
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Choice wrong,Choice again :");
            }

        } while (poisition.equals(""));
        return poisition;
    }

    @Override
    public String toString() {
        return "Employee :" + super.toString() + "Degree :" + degree() + "The Position :" + position()
                + "Salary :" + this.salary;
    }

}
