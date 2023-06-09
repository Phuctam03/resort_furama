package controller;

import java.util.Scanner;

import serivce.CustomerService;
import serivce.EmployeeService;
import serivce.FacilityService;

public class FuramaController {
    Scanner sc = new Scanner(System.in);

    public void menuFurama() {
        int luachon = 0;
        do {
            try {
                System.out.println("1.Employee Managements");
                System.out.println("2.Customer Managements");
                System.out.println("3.Faciliti Managements");
                System.out.println("4.Booking Managements");
                System.out.println("5.Promotion Managements");
                System.out.println("6.Exit");
                System.out.println();
                System.out.println("Enter the choice(1->5) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        employeeManagements();
                        break;
                    case 2:
                        customerManagements();
                        break;
                    case 3:
                        facilityManagements();
                        break;
                    case 4:
                        bookingManagements();
                        break;
                    case 5:
                        promotionManagements();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("choice wrong,choice again :");
            }

        } while (luachon != 6);
    }

    void employeeManagements() {
        EmployeeService employeeService = new EmployeeService();
        int luachon = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("1.Display list employees");
                System.out.println("2.Add new employee");
                System.out.println("3.Edit employee");
                System.out.println("4.Return  main menu");
                System.out.println();
                System.out.println("Enter the choice(1->4) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        employeeService.list();
                        break;
                    case 2:
                        employeeService.add();
                        break;
                    case 3:
                        employeeService.editByid();
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Choice wrong, choice again :");
            }

        }
    }

    void customerManagements() {
        CustomerService customerService = new CustomerService();
        int luachon = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("1.Display list Customer");
                System.out.println("2.Add new Customer");
                System.out.println("3.Edit Customer");
                System.out.println("4.Return  main menu");
                System.out.println();
                System.out.println("Enter the choice(1->4) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        customerService.list();
                        break;
                    case 2:
                        customerService.add();
                        break;
                    case 3:
                        customerService.editbyid();
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Choice wrong, choice again :");
            }

        }
    }

    void facilityManagements() {
        FacilityService menuFacilityService = new FacilityService();
        int luachon = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("1.Display list facility");
                System.out.println("2.Add new facility");
                System.out.println("3.Display maintainance facility");
                System.out.println("4.Return  main menu");
                System.out.println();
                System.out.println("Enter the choice(1->4) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        menuFacilityService.listFacility();
                        break;
                    case 2:
                        menuFacilityService.addFacility();
                        break;
                    case 3:
                        menuFacilityService.listFacilityMaintance();
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Choice wrong, choice again :");
            }

        }
    }

    void bookingManagements() {
        int luachon = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("1.Add new Booking");
                System.out.println("2.Display list booking");
                System.out.println("3.Create new contracts");
                System.out.println("4.Display list  contracts");
                System.out.println("5.Edit contracts");
                System.out.println("6.Return  main menu");
                System.out.println();
                System.out.println("Enter the choice(1->6) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong, choice again :");
            }

        }
    }

    void promotionManagements() {
        int luachon = 0;
        boolean check = true;
        while (check) {
            try {
                System.out.println("1.Display list customers use service");
                System.out.println("2.Display list customers get voucher");
                System.out.println("4.Return  main menu");
                System.out.println();
                System.out.println("Enter the choice(1->4) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        check = false;
                        break;
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Choice wrong, choice again :");
            }

        }
    }
}