package serivce;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.Employee;
import repository.EmployeeRepository;
import util.EmployeeUtil;
import util.myRegex;

public class EmployeeService implements IEmployee {

    Scanner sc = new Scanner(System.in);

    @Override
    public void list() throws IOException {
        List<Employee> e = EmployeeRepository.readFile();
        for (Employee employee : e) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void add() throws IOException {
        String id;
        String nameEmployee;
        String birthDay;
        String gender;
        String identityCard;
        String phone;
        String email;
        String degree;
        String position;
        double salary;
        System.out.println("Enter the idEmployee :");
        id = myRegex.testId(sc.nextLine());
        System.out.println("Enter the name Employee :");
        nameEmployee = myRegex.testName(sc.nextLine());
        System.out.println("Enter the Birhday employee :");
        birthDay = myRegex.testDate(sc.nextLine());
        System.out.println("Select gender: ");
        gender = EmployeeUtil.selectGender();
        System.out.println("enter indentityCard :");
        identityCard = myRegex.testCMND(sc.nextLine());
        System.out.println("Entet the phone :");
        phone = myRegex.testPhone(sc.nextLine());
        System.out.println("Enter the email");
        email = myRegex.testEmail(sc.nextLine());
        System.out.println("Select degree");
        degree = EmployeeUtil.degree();
        System.out.println("Select position");
        position = EmployeeUtil.position();
        System.out.println("Enter the salary :");
        salary = EmployeeUtil.checkSalary(sc.nextDouble());
        EmployeeRepository.addEmployee(
                new Employee(id, nameEmployee, birthDay, gender, identityCard, phone, email, degree, position, salary));

    }

    @Override
    public Employee edit(String id) throws IOException {
        boolean checkcase = true;
        int luachon = 0;
        do {
            for (Employee e : EmployeeRepository.readFile()) {
                if (e.getId().equalsIgnoreCase(id.trim())) {
                    System.out.println("1.edit name");
                    System.out.println("2.edit birthday");
                    System.out.println("3.edit gender");
                    System.out.println("4.edit identityCard");
                    System.out.println("5.edit Phone");
                    System.out.println("6.edit email");
                    System.out.println("7.edit degree");
                    System.out.println("8.edit position");
                    System.out.println("9.edit salary");
                    System.out.println();
                    System.out.println("Do you want to edit ?");
                    luachon = Integer.parseInt(sc.nextLine());
                    switch (luachon) {
                        case 1:
                            System.out.println("Edit the name :");
                            e.setNamePerson(myRegex.testName(id));
                            break;
                        case 2:
                            System.out.println("Edit the birthdate :");
                            e.setBirthDay(myRegex.testDate(sc.nextLine()));
                            break;
                        case 3:
                            System.out.println("Edit the gender :");
                            e.setGender(EmployeeUtil.selectGender());
                            break;
                        case 4:
                            System.out.println("Edit identityCard :");
                            e.setIdentityCard(sc.nextLine());
                            break;
                        case 5:
                            System.out.println("edit the phone :");
                            e.setPhone(myRegex.testPhone(sc.nextLine()));
                            break;
                        case 6:
                            System.out.println("Edit the email :");
                            e.setEmail(myRegex.testEmail(sc.nextLine()));
                            break;
                        case 7:
                            System.out.println("Edit degree");
                            e.setDegree(EmployeeUtil.degree());
                            break;
                        case 8:
                            System.out.println("Edit position");
                            e.setPosition(EmployeeUtil.position());
                            break;
                        case 9:
                            System.out.println("Edit the slary :");
                            e.setSalary(Double.parseDouble(sc.nextLine()));
                            break;
                    }
                    EmployeeRepository.saveupdate(); // y tuong can them
                    System.out.println("Do you want to edit again (y/n) :");
                    if (sc.nextLine().equalsIgnoreCase("n".trim())) {
                        checkcase = false;
                    } else {
                        edit(id);
                    }
                    return e;
                } else {
                    checkcase = false;
                }
            }
        } while (checkcase);
        return null;
    }

    public void editByid() throws IOException {
        while (true) {
            System.out.println("Enter the id you edit :");
            Employee e2 = edit(sc.nextLine());
            if (e2 != null) {
                System.out.println(e2.toString());
            } else {
                System.out.println("not find ");
            }
            System.out.println("Do you want to continue(y/n)");
            if (sc.nextLine().equalsIgnoreCase("n".trim())) {
                break;
            }
        }
    }
}
