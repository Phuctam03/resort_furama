package serivce;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import repository.FacilityRepository;
import util.FacilityUtil;
import util.myRegex;

public class FacilityService implements IFacilityService {
    Scanner sc = new Scanner(System.in);

    public FacilityService() {
    }

    @Override
    public void list() throws IOException {
        int count = 0;
        Map<Facility, Integer> myMap = FacilityRepository.readFileHouse();
        Set<Facility> mySet = myMap.keySet();
        for (Facility facility : mySet) {
            System.out.println(++count + ":" + facility.toString());
        }
    }

    @Override
    public void add() throws IOException {
        String id;
        String nameService;
        double useArea;
        double priceHire;
        int numberPeople;
        String typeRental;
        String typeRoom;
        int floor;
        System.out.println("Enter the id :");
        id = myRegex.testFacilityHouse(sc.nextLine());// chua xu ly Trung id ;
        System.out.println("Enter the name Service :");
        nameService = myRegex.testName(sc.nextLine());
        System.out.println("Enter the useArea :");
        useArea = myRegex.maxUseArea(sc.nextDouble());
        System.out.println("Enter the hireCost :");
        priceHire = myRegex.priceHire(sc.nextDouble());
        System.out.println("Enter the numberPeople :");
        numberPeople = myRegex.maxPeople(sc.nextInt());
        System.out.println("Select the typeRental :");
        typeRental = FacilityUtil.typeRental();
        System.out.println("Select the typeRoom :");
        typeRoom = FacilityUtil.typeRoom();
        System.out.println("Enter the floor :");
        floor = myRegex.maxFloor(sc.nextInt());
        FacilityRepository
                .addFacility(new House(id, nameService, useArea, priceHire, numberPeople, typeRental, typeRoom, floor));
    }

    @Override
    public void listFacilityMaintance() throws IOException {
        System.out.println("***LIST MAINTANCE FACILITY***");
        Map<Facility, Integer> myMap = FacilityRepository.readFileFacility();
        Set<Entry<Facility, Integer>> mySet = myMap.entrySet();
        for (Entry<Facility, Integer> entry : mySet) {
            if (entry.getValue() >= 5) {
                System.out.println(entry.getKey());
            }
        }
    }
    
    public void addVilla() throws IOException {
        String id;
        String nameService;
        double useArea;
        double priceHire;
        int numberPeople;
        String typeRental;
        String roomRank;
        double areaPool;
        int floor;
        System.out.println("Enter the id :");
        id = myRegex.testFacilityVilla(sc.nextLine());
        System.out.println("Enter the name Service");
        nameService = myRegex.testName(sc.nextLine());
        System.out.println("Enter the useArea");
        useArea = myRegex.maxUseArea(sc.nextDouble());
        System.out.println("Enter the priceHire");
        priceHire = myRegex.priceHire(sc.nextDouble());
        System.out.println("Enter the numberPeople");
        numberPeople = myRegex.maxPeople(sc.nextInt());
        System.out.println("Select the typeRental");
        typeRental = FacilityUtil.typeRental();
        System.out.println("Select the roomRank");
        roomRank = FacilityUtil.typeRoom();
        System.out.println("Enter the useareaPool");
        areaPool = myRegex.maxUsePool(sc.nextDouble());
        System.out.println("Enter the floor");
        floor = myRegex.maxFloor(sc.nextInt());
        FacilityRepository.addFacility(
                new Villa(id, nameService, useArea, priceHire, numberPeople, typeRental, roomRank, areaPool, floor));

    }

    public void listVilla() throws IOException {
        int count = 0;
        Map<Facility, Integer> myMap = FacilityUtil.readFileVilla();
        Set<Facility> myFacilities = myMap.keySet();
        for (Facility facility : myFacilities) {
            System.out.println(++count + ":" + facility.toString());
        }
    }

    public void addRoom() throws IOException {
        String id;
        String nameService;
        double useArea;
        double priceHire;
        int numberPeople;
        String typeRental;
        String freeService;
        System.out.println("Enter the id :");
        id = myRegex.testFacilityRoom(sc.nextLine());
        System.out.println("Enter the name Service");
        nameService = myRegex.testName(sc.nextLine());
        System.out.println("Enter the useArea");
        useArea = myRegex.maxUseArea(sc.nextDouble());
        System.out.println("Enter the priceHire");
        priceHire = myRegex.priceHire(sc.nextDouble());
        System.out.println("Enter the numberPeople");
        numberPeople = myRegex.maxPeople(sc.nextInt());
        System.out.println("Select the typeRental");
        typeRental = FacilityUtil.typeRental();
        System.out.println("Slect the freeService");
        freeService = FacilityUtil.freeService();
        FacilityRepository
                .addFacility(new Room(id, nameService, useArea, priceHire, numberPeople, typeRental, freeService));
    }

    public void listRoom() throws IOException {
        int count = 0;
        Map<Facility, Integer> myMap = FacilityRepository.readFileRoom();
        Set<Facility> mySet = myMap.keySet();
        for (Facility facility : mySet) {
            System.out.println(++count + ":" + facility.toString());

        }
    }

    public void listAll() throws IOException {
        int count = 0;
        Map<Facility, Integer> myMap = FacilityRepository.readFileFacility();
        Set<Facility> mySet = myMap.keySet();
        for (Facility facility : mySet) {
            System.out.println(++count + ":" + facility.toString());
        }

    }

    public void addFacility() {
        int luachon = 0;
        boolean checkCast = true;

        do {
            try {
                System.out.println("1.Add New Villa");
                System.out.println("2.Add New House");
                System.out.println("3.Add New Room");
                System.out.println("4.Back to menu");
                System.out.println("Choice (1->3)");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        addVilla();
                        break;
                    case 2:
                        add();
                        break;
                    case 3:
                        addRoom();
                        break;
                    case 4:
                        checkCast = false;
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong, Choice again");
            }

        } while (checkCast);

    }

    public void listFacility() {
        int luachon = 0;
        boolean checkCast = true;

        do {
            try {
                System.out.println("1.list all Facility");
                System.out.println("2.List  House ");
                System.out.println("3.List Villa");
                System.out.println("4.List Room");
                System.out.println("5.Back to menu");
                System.out.println("Choice (1->3)");
                luachon = Integer.parseInt(sc.nextLine());
                switch (luachon) {
                    case 1:
                        listAll();
                        break;
                    case 2:
                        list();
                        break;
                    case 3:
                        listVilla();
                        break;
                    case 4:
                        listRoom();
                        break;
                    case 5:
                        checkCast = false;
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Choice wrong, Choice again");
            }

        } while (checkCast);

    }

}
