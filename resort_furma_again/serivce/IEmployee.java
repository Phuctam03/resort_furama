package serivce;

import java.io.IOException;

import model.Employee;

public interface IEmployee extends Service {

    public Employee edit(String id) throws NumberFormatException, IOException;

}
