package util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Scanner;

import model.Customer;
import model.Employee;
import repository.CustomerRepository;
import repository.EmployeeRepository;

public class myRegex {
    static Scanner sc = new Scanner(System.in);
    private static final String DATE_FORMAT = "\\d{2}/\\d{2}/\\d{4}";
    private static final String CMND_FORMAT = "^[0-9]{9,12}$";
    private static final String PHONE_FORMAT = "^0[0-9]{9}$";
    private static final String ID_FORMAT = "^NV-[0-9]{4}$";
    private static final String ID_CUSTOMER = "^KH-[0-9]{4}$";
    private static final String EMAIL_FORMAT = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String REGEX_FULL_NAME = "[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(([\\sAÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+)+)?";

    public static boolean isDateRight(String dateStr) {
        if (!dateStr.matches(DATE_FORMAT)) {
            return false;
        }
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] dateArr = dateStr.split("/");
        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        if (month < 0 || month > 12) {
            return false;
        }
        Year year = Year.of(Integer.parseInt(dateArr[2]));
        if (year.isLeap()) {
            daysInMonth[1] = 29;
        }
        return day >= 0 && day <= daysInMonth[month - 1];
    }

    public static boolean isInOutDateRight(LocalDate inDate, LocalDate outDate) {
        return Period.between(inDate, outDate).getDays() >= 0;
    }

    public static boolean isName(String Name) {
        return Name.matches(REGEX_FULL_NAME);
    }

    public static boolean isCMND(String CMND) {
        return CMND.matches(CMND_FORMAT);
    }

    public static boolean isId(String ID) {
        return ID.matches(ID_FORMAT);
    }

    public static boolean isPhone(String Phone) {
        return Phone.matches(PHONE_FORMAT);
    }

    public static boolean isEmail(String email) {
        return email.matches(EMAIL_FORMAT);
    }

    public static boolean isIDCustomer(String id) {
        return id.matches(ID_CUSTOMER);
    }

    public static String testDate(String date) {
        while (!(myRegex.isDateRight(date))) {
            System.out.println("Invalid date form,please again(dd/MM/yyy) :");
            date = sc.nextLine();
        }
        return date;
    }

    public static String testId(String id) throws IOException {
        boolean checkcast = true;
        while (checkcast) {
            if (!isId(id)) {
                System.out.println("id formatting(NV-YYYY) :");
                id = sc.nextLine();
                testId(id);
            } else if (checkDuplicateID(id)) {
                System.out.println("the id duplicate :");
                id = sc.nextLine();
                testId(id);
            }
            checkcast = false;
        }
        return id;
    }

    public static boolean checkDuplicateID(String id) throws IOException {
        for (Employee e : EmployeeRepository.readFile()) {
            if (e.getId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }

    public static String testPhone(String phone) {
        while (!isPhone(phone)) {
            System.out.println("Enter wrong formatting(start 0 - (10))");
            phone = sc.nextLine();
        }
        return phone;
    }

    public static String testCMND(String idetitycard) {
        while (!isCMND(idetitycard)) {
            System.out.println("Enter wrong formatting(9 or 12 number)");
            idetitycard = sc.nextLine();
        }
        return idetitycard;
    }

    public static String testEmail(String email) {
        while (!isEmail(email)) {
            System.out.println("Enter Wrong formatting(abc@gmail.com) ");
            email = sc.nextLine();
        }
        return email;
    }

    public static String testName(String Name) {
        while (!isName(Name)) {
            System.out.println("Enter Wrong formatting(upercase first Name) ");
            Name = sc.nextLine();
        }
        return Name;
    }

    public static String testIdCustomer(String id) throws IOException {
        boolean checkcast = true;
        while (checkcast) {
            if (!isIDCustomer(id)) {
                System.out.println("id formatting(KH-YYYY) :");
                id = sc.nextLine();
                testIdCustomer(id);
            } else if (checkDuplicateIDCustomer(id)) {
                System.out.println("the id duplicate :");
                id = sc.nextLine();
                testIdCustomer(id);
            }
            checkcast = false;
        }
        return id;
    }

    public static boolean checkDuplicateIDCustomer(String id) throws IOException {
        for (Customer c : CustomerRepository.readFile()) {
            if (c.getId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }

}
