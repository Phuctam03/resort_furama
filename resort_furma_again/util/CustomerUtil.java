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

import model.Customer;

public class CustomerUtil {
    private static final String FILE_PATH = "D:\\code_java\\codeGym\\resort_furma_again\\data\\customer.csv";
    public static List<Customer> customersList = new ArrayList<>();

    public static String typeGuest() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String typeguest = "";

        do {
            try {
                System.out.println("1.Diamond");
                System.out.println("2.Platinum");
                System.out.println("3.Gold");
                System.out.println("4.Silver");
                System.out.println("5.Member");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        typeguest = "Diamond";
                        break;
                    case 2:
                        typeguest = "Platium";
                        break;
                    case 3:
                        typeguest = "Gold";
                        break;
                    case 4:
                        typeguest = "Silver";
                        break;
                    case 5:
                        typeguest = "Member";
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong,Choice again");
            }
        } while (typeguest.equals(""));
        return typeguest;
    }

    public static List<Customer> readFileCustomer() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String temp[];
        Customer customer;
        customersList.clear();
        while ((line = bufferedReader.readLine()) != null && !(line.equals(""))) {
            temp = line.split(",");
            String id = temp[0];
            String namePerson = temp[1];
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
            Calendar birthDay = dateOfBirth;
            String gender = temp[3];
            String identityCard = temp[4];
            String phone = temp[5];
            String email = temp[6];
            String typeGuest = temp[7];
            String address = temp[8];
            customer = new Customer(id, namePerson, birthDay, gender, identityCard, phone, email, typeGuest, address);
            customersList.add(customer);
        }
        bufferedReader.close();
        return customersList;
    }

    public static void writeFile(Customer customer) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(customer.getId() + "," + customer.getNamePerson() + "," + customer.getBirthDay() + ","
                + customer.getGender() + "," + customer.getIdentityCard() + "," + customer.getPhone() + ","
                + customer.getEmail() + "," + customer.getTypeGuest() + "," + customer.getAddress() + "\n");
        bufferedWriter.close();
    }

    public static void writeListFile(List<Customer> customersList) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Customer customer : customersList) {
            bufferedWriter.write(customer.getId() + "," + customer.getNamePerson() + "," + customer.getBirthDay() + ","
                    + customer.getGender() + "," + customer.getIdentityCard() + "," + customer.getPhone() + ","
                    + customer.getEmail() + "," + customer.getTypeGuest() + "," + customer.getAddress() + "\n");
        }
        bufferedWriter.close();
    }

}
