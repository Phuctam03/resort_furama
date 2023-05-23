package repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import util.CustomerUtil;

public class CustomerRepository {

    public static List<Customer> customerslList = new ArrayList<>();

    public static List<Customer> getCustomerslList() {
        return customerslList;
    }

    public static void setCustomerslList(List<Customer> customerslList) {
        CustomerRepository.customerslList = customerslList;
    }

    public static List<Customer> readFile() throws IOException {
        customerslList = CustomerUtil.readFileCustomer();
        return customerslList;
    }

    public static void addCustomer(Customer customer) throws IOException {
        customerslList.add(customer);
        CustomerUtil.writeFile(customer);
        System.out.println("add Customer successfully :" + customer.getNamePerson());
    }

    public static void update() throws IOException {
        CustomerUtil.writeListFile(customerslList);
    }

}
