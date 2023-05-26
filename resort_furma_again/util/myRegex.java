package util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Calendar;
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
    private static final String REGEX_FULL_NAME = "[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(([\\sAÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+)+)?";
    public static final String SERVICE_CODE_REGEXVILLA = "SV(VL)-[\\d]{4}";
    public static final String SERVICE_CODE_REGEXHOUSE = "SV(HO)-[\\d]{4}";
    public static final String SERVICE_CODE_REGEXROOM = "SV(RO)-[\\d]{4}";

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

    public static boolean isIDFacilityVilla(String id) {
        return id.matches(SERVICE_CODE_REGEXVILLA);
    }

    public static boolean isIDFacilityHouse(String id) {
        return id.matches(SERVICE_CODE_REGEXHOUSE);
    }

    public static boolean isIDFacilityRoom(String id) {
        return id.matches(SERVICE_CODE_REGEXROOM);
    }

    public static String testFacilityVilla(String id) {
        while (!isIDFacilityVilla(id)) {
            System.out.println("id formatting (SVVL_YYYY)");
            id = sc.nextLine();
        }
        return id;
    }

    public static String testFacilityHouse(String id) {
        while (!isIDFacilityHouse(id)) {
            System.out.println("id formatting (SVHO_YYYY)");
            id = sc.nextLine();
        }
        return id;
    }

    public static String testFacilityRoom(String id) {
        while (!isIDFacilityRoom(id)) {
            System.out.println("id formatting (SVRO_YYYY)");
            id = sc.nextLine();
        }
        return id;
    }

    public static Double priceHire(Double priceHire) {
        while (priceHire <= 0) {
            System.out.println("The price Hire (>30)");
            priceHire = Double.parseDouble(sc.nextLine());
        }
        return priceHire;
    }

    public static int maxPeople(int numberPeople) {
        while (numberPeople <= 0 || numberPeople >= 20) {
            System.out.println("number people  (0 -> 20 )");
            numberPeople = Integer.parseInt(sc.nextLine());
        }
        return numberPeople;
    }

    public static double maxUseArea(double useArea) {
        while (useArea < 30) {
            System.out.println("useArea > 30 :");
            useArea = Double.parseDouble(sc.nextLine());
        }
        return useArea;
    }

    public static double maxUsePool(double usePool) {
        while (usePool < 30) {
            System.out.println("usePool > 30 :");
            usePool = Double.parseDouble(sc.nextLine());
        }
        return usePool;
    }

    public static int maxFloor(int maxFloor) {
        while (maxFloor <= 0) {
            System.out.println("Floor > 0 ");
            maxFloor = Integer.parseInt(sc.nextLine());
        }
        return maxFloor;
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

    public static Calendar stringToCalendar(String date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = null;
        java.util.Date d;
        try {
            d = df.parse(date);
            c = Calendar.getInstance();
            c.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c;
    }

    public static boolean isFormatDay(String n) {
        return n.matches(DATE_FORMAT);
    }

    public static boolean isEnoughAge(Calendar date) {
        int validAge = 365 * 18;
        Calendar now = Calendar.getInstance();
        int ageCheck = now.get(Calendar.YEAR) - date.get(Calendar.YEAR) - 1;
        int dayCheck = now.get(Calendar.MONTH) + (12 - date.get(Calendar.MONTH));
        int check = (ageCheck * 365) + (dayCheck * 30);
        if (check < validAge) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidDate(String date) {
        String dateFormat = "dd/MM/yyyy";
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static Calendar enterdateOfBirth() {
        String date;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Date of birth(DD/MM/YYYY) : ");
            date = sc.nextLine();
            if (date.isEmpty()) {
                System.out.println("The input is empty !Please re-enter");
            } else if (isValidDate(date)) {
                Calendar c = stringToCalendar(date);
                if (!isFormatDay(date)) {
                    System.out.println("Nhap sai dinh dang(DD/MM/YYYY)");
                } else if (isEnoughAge(c)) {
                    return c;
                } else {
                    System.out.println("The age must greater than 18 years old ! ");
                }
            } else {
                System.out.println("The date of birth you just entered is  invalid !Please re-enter");
            }
        }
    }

    public static void main(String[] args) {

    }

}
