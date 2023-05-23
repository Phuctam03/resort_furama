package serivce;

import java.io.IOException;

import model.Customer;

public interface ICustomer extends Service {


    public Customer edit(String id ) throws IOException;

}
