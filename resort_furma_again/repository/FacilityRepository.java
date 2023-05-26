package repository;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import util.FacilityUtil;

public class FacilityRepository {

    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    public static int useVilla = 0;
    public static int useRoom = 0;
    public static int useHouse = 0;

    public static Map<Facility, Integer> getFacilityMap() {
        return facilityMap;
    }

    public static void setFacilityMap(Map<Facility, Integer> facilityMap) {
        FacilityRepository.facilityMap = facilityMap;
    }

    public static Map<Facility, Integer> readFileHouse() throws IOException {
        facilityMap = FacilityUtil.readFileHouse();
        return facilityMap;

    }

    public static Map<Facility, Integer> readFileVilla() throws IOException {
        facilityMap = FacilityUtil.readFileVilla();
        return facilityMap;
    }

    public static Map<Facility, Integer> readFileRoom() throws IOException {
        facilityMap = FacilityUtil.readFileRoom();
        return facilityMap;
    }

    public static Map<Facility, Integer> readFileFacility() throws IOException {
        facilityMap = FacilityUtil.readFileFacility();
        return facilityMap;
    }

    public static void addFacility(Facility addService) throws IOException {
        if (addService instanceof House) {
            facilityMap.put(addService, ++useHouse);
            FacilityUtil.writeFileHouse((House) addService);
            FacilityUtil.writeFileHouseFacility((House) addService);
            System.out.println("Add successfuly :" + addService.getNameService());
        } else if (addService instanceof Villa) {
            facilityMap.put(addService, ++useVilla);
            FacilityUtil.writeFileVilla((Villa) addService);
            FacilityUtil.writeFileVillaFacility((Villa) addService);
            System.out.println("Add successfully :" + addService.getNameService());
        } else {
            facilityMap.put(addService, ++useRoom);
            FacilityUtil.writeFileRoom((Room) addService);
            FacilityUtil.writeFileRoomFacility((Room) addService);
            System.out.println("Add successfully :" + addService.getNameService());
        }
    }

}