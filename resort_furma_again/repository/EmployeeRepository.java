package repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.EmployeeUtil;

public class EmployeeRepository {
    static List<Employee> employeeList = new ArrayList<>();

    public static List<Employee> getEmployee() {
        return employeeList;
    }

    public static void setEmployee(List<Employee> employee) {
        EmployeeRepository.employeeList = employee;
    }
    public static List<Employee> readFile() throws IOException {
        employeeList = EmployeeUtil.readFileList();
        return employeeList;
    }
    public static void addEmployee(Employee employee) throws IOException {
        employeeList.add(employee);
        EmployeeUtil.writeFileList(employee);
        System.out.println("Add succefully :" + employee.getNamePerson());
    }

    public static void saveupdate() throws IOException {
        EmployeeUtil.writeLsitFile(employeeList);
    }

}
