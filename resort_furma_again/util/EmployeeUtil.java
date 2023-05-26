package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import model.Employee;

public class EmployeeUtil {
    private static final String FILE_PATH = "D:\\code_java\\codeGym\\resort_furma_again\\data\\employee.csv";
    static List<Employee> employeesList = new ArrayList<>();

    public static String selectGender() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String gender = "";
        do {
            try {
                System.out.println("1.Male");
                System.out.println("2.female");
                System.out.println("3.Other");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        gender = "Male";
                        break;
                    case 2:
                        gender = "Female";
                        break;
                    case 3:
                        gender = "Other";
                        break;

                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong,choice again ");
            }

        } while (gender.equals(""));
        return gender;

    }

    public static String degree() {
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
                System.out.println("Choice wrong,choice agian ");
            }

        } while (degree.equals(""));
        return degree;
    }

    public static String position() {
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

    public static List<Employee> readFileList() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String temp[];
        Employee employee;
        employeesList.clear();
        while ((line = bufferedReader.readLine()) != null && !(line.equals(""))) {
            temp = line.split(",");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = null;
            java.util.Date d;
            try {
                d = df.parse(temp[2]);
                c = Calendar.getInstance();
                c.setTime(d);
            } catch (ParseException b) {
                b.printStackTrace();
            }
            Calendar dateOfBirth = c;
            String id = temp[0];
            String name = temp[1];
            Calendar birthday = dateOfBirth;
            String gender = temp[3];
            String identityCard = temp[4];
            String phone = temp[5];
            String email = temp[6];
            String degree = temp[7];
            String position = temp[8];
            double salary = Double.parseDouble(temp[9]);
            employee = new Employee(id, name, birthday, gender, identityCard, phone, email, degree, position, salary);
            employeesList.add(employee);
        }
        bufferedReader.close();
        return employeesList;
    }

    public static void writeFileList(Employee employee) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(employee.getId() + "," + employee.getNamePerson() + ","
                + employee.getBirthDay() + ","
                + employee.getGender() + "," + employee.getIdentityCard() + "," +
                employee.getPhone() + ","
                + employee.getEmail() + "," + employee.getDegree() + "," +
                employee.getPosition() + ","
                + employee.getSalary() + "\n");
        bufferedWriter.close();
    }

    public static void writeLsitFile(List<Employee> listEMployee) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Employee employee : listEMployee) {
            bufferedWriter.write(employee.getId() + "," + employee.getNamePerson() + ","
                    + employee.getBirthDay() + ","
                    + employee.getGender() + "," + employee.getIdentityCard() + "," +
                    employee.getPhone() + ","
                    + employee.getEmail() + "," + employee.getDegree() + "," +
                    employee.getPosition() + ","
                    + employee.getSalary() + "\n");
        }
        bufferedWriter.close();
    }

    public static double checkSalary(double salary) {
        Scanner sc = new Scanner(System.in);
        while (salary <= 0) {
            System.out.println("salary than 0 ");
            salary = Double.parseDouble(sc.nextLine());
        }
        return salary;
    }

    public static void main(String[] args) throws IOException {
        // List<Employee> employees = EmployeeUtil.readFileList();
        // System.out.println("Read file -Employee :");
        // for (Employee employee : employees) {
        // System.out.println(employee.toString());
        // }
        // EmployeeUtil.writeFileList(
        // new Employee("123", "456", "789", "Nam", "456", "1234", "12315125",
        // "4564721", "123132", 400.6));
        // }
    }
}
