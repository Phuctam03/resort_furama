package serivce;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import repository.CustomerRepository;
import util.CustomerUtil;
import util.EmployeeUtil;
import util.myRegex;

public class CustomerService implements ICustomer {
    Scanner sc = new Scanner(System.in);

    @Override
    public void list() throws IOException {
        List<Customer> customersService = CustomerRepository.readFile();
        for (Customer customer : customersService) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void add() throws IOException {
        String id;
        String namePerson;
        String birthDay;
        String gender;
        String identityCard;
        String phone;
        String email;
        String typeGuest;
        String address;
        System.out.println("Enter the idCustomer :");
        id = myRegex.testIdCustomer(sc.nextLine());
        System.out.println("Enter the name Customer :");
        namePerson = myRegex.testName(sc.nextLine());
        System.out.println("Enter the birthday");
        birthDay = myRegex.testDate(sc.nextLine());
        System.out.println("Select the gender :");
        gender = EmployeeUtil.selectGender();
        System.out.println("Enter the identityCard :");
        identityCard = myRegex.testCMND(sc.nextLine());
        System.out.println("Enter the phone :");
        phone = myRegex.testPhone(sc.nextLine());
        System.out.println("enter the email :");
        email = myRegex.testEmail(sc.nextLine());
        System.out.println("Select the typeGuest :");
        typeGuest = CustomerUtil.typeGuest();
        System.out.println("Enter the address :");
        address = sc.nextLine();
        CustomerRepository.addCustomer(
                new Customer(id, namePerson, birthDay, gender, identityCard, phone, email, typeGuest, address));
    }

    @Override
    public Customer edit(String id) throws IOException {
        boolean checkcast = true;
        int luachon = 0;
        do {
            try {
                for (Customer customer : CustomerRepository.readFile()) {
                    if (customer.getId().equalsIgnoreCase(id.trim())) {
                        System.out.println("1.Edit the name ");
                        System.out.println("2.Edit the birthDay");
                        System.out.println("3.Select the gender");
                        System.out.println("4.Edit the identityCard");
                        System.out.println("5.Edit the phone");
                        System.out.println("6.Edit the email");
                        System.out.println("7.Select the TypeGuest");
                        System.out.println("8.Edit the address");
                        luachon = Integer.parseInt(sc.nextLine());
                        switch (luachon) {
                            case 1:
                                System.out.println("Edit the name :");
                                customer.setNamePerson(myRegex.testName(sc.nextLine()));
                                break;
                            case 2:
                                System.out.println("Edit the birthday :");
                                customer.setBirthDay(myRegex.testDate(sc.nextLine()));
                                break;
                            case 3:
                                System.out.println("Edit the gender :");
                                customer.setGender(EmployeeUtil.selectGender());
                                break;
                            case 4:
                                System.out.println("Edit the identityCard :");
                                customer.setIdentityCard(myRegex.testCMND(sc.nextLine()));
                                break;
                            case 5:
                                System.out.println("Edit the phone :");
                                customer.setPhone(myRegex.testPhone(sc.nextLine()));
                                break;
                            case 6:
                                System.out.println("Edit the email:");
                                customer.setEmail(myRegex.testEmail(sc.nextLine()));
                                break;
                            case 7:
                                System.out.println("Select the type Guest again:");
                                customer.setTypeGuest(CustomerUtil.typeGuest());
                                break;
                            case 8:
                                System.out.println("Edit the address :");
                                customer.setAddress(sc.nextLine());
                                break;
                            default:
                                throw new Exception();
                        }
                        CustomerRepository.update();
                        System.out.println("Do you want to edit again(y/n)");
                        if (sc.nextLine().equalsIgnoreCase("n".trim())) {
                            checkcast = false;
                        } else {
                            edit(id);
                        }
                        return customer;
                    } else {
                        checkcast = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Choice wrong,Choice again");
            }

        } while (checkcast);
        return null;

    }

    public void editbyid() throws IOException {
        while (true) {
            System.out.println("enter the id edit :");
            Customer customer = edit(sc.nextLine());
            if (customer != null) {
                System.out.println(customer.toString());
            } else {
                System.out.println("Not find ");
            }
            System.out.println("do you want to continue(y/n)");
            if (sc.nextLine().equalsIgnoreCase("n".trim())) {
                break;
            }
        }
    }

}
