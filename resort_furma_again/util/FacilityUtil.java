package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import model.Facility;
import model.House;
import model.Room;
import model.Villa;

public class FacilityUtil {

    private static final String FILE_PATH_FACILITY = "D:\\code_java\\codeGym\\resort_furma_again\\data\\Facility.csv";
    private static final String FILE_PATH_HOUSE = "D:\\code_java\\codeGym\\resort_furma_again\\data\\house.csv";
    private static final String FILE_PATH_ROOM = "D:\\code_java\\codeGym\\resort_furma_again\\data\\room.csv";
    private static final String FILE_PATH_VILLA = "D:\\code_java\\codeGym\\resort_furma_again\\data\\villa.csv";

    static Map<Facility, Integer> FacilityList = new LinkedHashMap<>();
    public static int useVilla = 0;
    public static int useHouse = 0;
    public static int useRoom = 0;

    public static String typeRental() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String rental = "";
        do {
            try {
                System.out.println("1.Year");
                System.out.println("2.Month");
                System.out.println("3.Day");
                System.out.println("4.Hour");
                System.out.println();
                System.out.println("Choice (1 -> 4) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        rental = "Year";
                        break;
                    case 2:
                        rental = "Month";
                        break;
                    case 3:
                        rental = "Day";
                        break;
                    case 4:
                        rental = "Hour";
                        break;

                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("choice wrong, choice agian");
            }
        } while (rental.equals(""));

        return rental;
    }

    public static String typeRoom() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String typeRoom = "";
        do {
            try {
                System.out.println("1.Room A");
                System.out.println("2.Room B");
                System.out.println("3.Room C");
                System.out.println("4.Room D");
                System.out.println("Choice(1 -> 4)");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        typeRoom = "Room A";
                        break;
                    case 2:
                        typeRoom = "Room B";
                        break;
                    case 3:
                        typeRoom = "Room C";
                        break;
                    case 4:
                        typeRoom = "Room D";
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong,Choice again");
            }

        } while (typeRoom.equals(""));

        return typeRoom;

    }

    public static String freeService() {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        String freeService = "";
        do {
            try {
                System.out.println("1.massage");
                System.out.println("2.karaoke");
                System.out.println("3.food");
                System.out.println("4.drink");
                System.out.println("5.car");
                System.out.println("Choice(1 ->5) :");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        freeService = "Bar";
                        break;
                    case 2:
                        freeService = "Service laudry";
                        break;
                    case 3:
                        freeService = "Service fitness center";
                        break;
                    case 4:
                        freeService = "Service spa";
                        break;
                    case 5:
                        freeService = "Room Service";
                    default:
                        throw new Exception();
                }

            } catch (Exception e) {
                System.out.println("Choice wrong,Choice again :");
            }

        } while (freeService.equals(""));
        return freeService;
    }

    public static Map<Facility, Integer> readFileHouse() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH_HOUSE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String temp[];
        Facility facilityHouse;
        FacilityList.clear();
        while ((line = bufferedReader.readLine()) != null && !(line.equals(""))) {
            temp = line.split(",");
            String id = temp[0];
            String nameService = temp[1];
            double useArea = Double.parseDouble(temp[2]);
            double priceHire = Double.parseDouble(temp[3]);
            int numberPeople = Integer.parseInt(temp[4]);
            String typeRental = temp[5];
            String typeRoom = temp[6];
            int floor = Integer.parseInt(temp[7]);
            facilityHouse = new House(id, nameService, useArea, priceHire, numberPeople, typeRental, typeRoom, floor);
            FacilityList.put(facilityHouse, ++useHouse);
        }
        bufferedReader.close();
        return FacilityList;
    }

    public static void writeFileHouse(House facilityHouse) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH_HOUSE, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(facilityHouse.getId() + "," + facilityHouse.getNameService() + ","
                + facilityHouse.getUseArea() + "," + facilityHouse.getPriceHire() + ","
                + facilityHouse.getNumberPeople() + "," + facilityHouse.getTypeRental() + ","
                + facilityHouse.getTypeRoom() + "," + facilityHouse.getFloor() + "\n");
        bufferedWriter.close();
    }

    public static void writeFileHouseFacility(House facilityHouse) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH_FACILITY, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(facilityHouse.getId() + "," + facilityHouse.getNameService() + ","
                + facilityHouse.getUseArea() + "," + facilityHouse.getPriceHire() + ","
                + facilityHouse.getNumberPeople() + "," + facilityHouse.getTypeRental() + ","
                + facilityHouse.getTypeRoom() + "," + facilityHouse.getFloor() + "\n");
        bufferedWriter.close();
    }

    public static Map<Facility, Integer> readFileVilla() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH_VILLA);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String temp[];
        Facility facilityVilla;
        FacilityList.clear();
        while ((line = bufferedReader.readLine()) != null && !(line.equals(""))) {
            temp = line.split(",");
            String id = temp[0];
            String nameService = temp[1];
            double useArea = Double.parseDouble(temp[2]);
            double priceHire = Double.parseDouble(temp[3]);
            int numberPeople = Integer.parseInt(temp[4]);
            String typeRental = temp[5];
            String roomRank = temp[6];
            double areaPool = Double.parseDouble(temp[7]);
            int floor = Integer.parseInt(temp[8]);
            facilityVilla = new Villa(id, nameService, useArea, priceHire, numberPeople, typeRental, roomRank, areaPool,
                    floor);
            FacilityList.put(facilityVilla, ++useVilla);
        }
        bufferedReader.close();
        return FacilityList;
    }

    public static void writeFileVilla(Villa facilityVilla) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH_VILLA, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter
                .write(facilityVilla.getId() + "," + facilityVilla.getNameService() + "," + facilityVilla.getUseArea()
                        + "," + facilityVilla.getPriceHire() + "," + facilityVilla.getNumberPeople() + ","
                        + facilityVilla.getTypeRental() + "," + facilityVilla.getRoomRank() + ","
                        + facilityVilla.getAreaPool() + "," + facilityVilla.getFloor() + "\n");
        bufferedWriter.close();
    }

    public static void writeFileVillaFacility(Villa facilityVilla) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH_FACILITY, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter
                .write(facilityVilla.getId() + "," + facilityVilla.getNameService() + "," + facilityVilla.getUseArea()
                        + "," + facilityVilla.getPriceHire() + "," + facilityVilla.getNumberPeople() + ","
                        + facilityVilla.getTypeRental() + "," + facilityVilla.getRoomRank() + ","
                        + facilityVilla.getAreaPool() + "," + facilityVilla.getFloor() + "\n");
        bufferedWriter.close();
    }

    public static Map<Facility, Integer> readFileRoom() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH_ROOM);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String temp[];
        Facility facilityRoom;
        FacilityList.clear();
        while ((line = bufferedReader.readLine()) != null && !(line.equals(""))) {
            temp = line.split(",");
            String id = temp[0];
            String nameService = temp[1];
            double useArea = Double.parseDouble(temp[2]);
            double priceHire = Double.parseDouble(temp[3]);
            int numberPeople = Integer.parseInt(temp[4]);
            String typeRental = temp[5];
            String freeService = temp[6];
            facilityRoom = new Room(id, nameService, useArea, priceHire, numberPeople, typeRental, freeService);
            FacilityList.put(facilityRoom, ++useRoom);
        }
        bufferedReader.close();
        return FacilityList;
    }

    public static void writeFileRoom(Room facilityRoom) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH_ROOM, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(facilityRoom.getId() + "," + facilityRoom.getNameService() + ","
                + facilityRoom.getUseArea() + "," + facilityRoom.getPriceHire() + "," + facilityRoom.getNumberPeople()
                + "," + facilityRoom.getTypeRental() + "," + facilityRoom.getFreeService() + "\n");
        bufferedWriter.close();
    }

    public static void writeFileRoomFacility(Room facilityRoom) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH_FACILITY, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(facilityRoom.getId() + "," + facilityRoom.getNameService() + ","
                + facilityRoom.getUseArea() + "," + facilityRoom.getPriceHire() + "," + facilityRoom.getNumberPeople()
                + "," + facilityRoom.getTypeRental() + "," + facilityRoom.getFreeService() + "\n");
        bufferedWriter.close();
    }

    public static Map<Facility, Integer> readFileFacility() throws IOException {
        FileReader fileReader = new FileReader(FILE_PATH_FACILITY);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String temp[];
        Facility facility;
        FacilityList.clear();
        String id;
        String nameService;
        double useArea;
        double priceHire;
        int numberPeople;
        String typeRental;
        while ((line = bufferedReader.readLine()) != null && !(line.equals(""))) {
            temp = line.split(",");
            id = temp[0];
            if (id.matches(myRegex.SERVICE_CODE_REGEXHOUSE)) {
                nameService = temp[1];
                useArea = Double.parseDouble(temp[2]);
                priceHire = Double.parseDouble(temp[3]);
                numberPeople = Integer.parseInt(temp[4]);
                typeRental = temp[5];
                String typeRoom = temp[6];
                int floor = Integer.parseInt(temp[7]);
                facility = new House(id, nameService, useArea, priceHire, numberPeople, typeRental, typeRoom, floor);
                FacilityList.put(facility, ++useHouse);
            } else if (id.matches(myRegex.SERVICE_CODE_REGEXROOM)) {
                nameService = temp[1];
                useArea = Double.parseDouble(temp[2]);
                priceHire = Double.parseDouble(temp[3]);
                numberPeople = Integer.parseInt(temp[4]);
                typeRental = temp[5];
                String freeService = temp[6];
                facility = new Room(id, nameService, useArea, priceHire, numberPeople, typeRental, freeService);
                FacilityList.put(facility, ++useRoom);
            } else {
                nameService = temp[1];
                useArea = Double.parseDouble(temp[2]);
                priceHire = Double.parseDouble(temp[3]);
                numberPeople = Integer.parseInt(temp[4]);
                typeRental = temp[5];
                String roomRank = temp[6];
                double areaPool = Double.parseDouble(temp[7]);
                int floor = Integer.parseInt(temp[8]);
                facility = new Villa(id, nameService, useArea, priceHire, numberPeople, typeRental, roomRank, areaPool,
                        floor);
                FacilityList.put(facility, ++useVilla);
            }
        }
        bufferedReader.close();
        return FacilityList;
    }

}
