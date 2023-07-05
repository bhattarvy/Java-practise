package LLD.conceptandcoding.parkinglot;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotApp {

    public static void main(String[] args) {

    }

}


// Models

@Data
@NoArgsConstructor
class ParkingLot {
    private List<Floor> floorList;
}

@Data
class Floor {
    private List<ParkingSpot> parkingSpots;
    private List<Gate> entryGate;
    private List<Gate> exitGate;
    private DisplayBoard displayBoard;
}

@Data
class ParkingSpot {
    private int id;
    private VehicleType vehicleType;
    private int price;
    private Vehicle vehicle;
}

@Data
class DisplayBoard{
    private Map<VehicleType, Integer> spotsCount;
    private int entryGateCount;
    private int exitGateCount;
}



@Data
class Gate{
    private String id;
    private String attendantId;
}

@Data
class Attendant {
    private String id;
    private String gateId;
}

@Data
class Vehicle{
    private int id;
    private int ownerName;
    private VehicleType vehicleType;
}

enum VehicleType{
    TWO_WHEELER,
    FOUR_WHEELER,
    TRUCk
}

@Data
class Ticket {
    private int id;
    private int vehicleId;
    private long issueTime;
    private VehicleType vehicleType;
    private Long exitTime = null;
    private int floorId;
    private PaymentType paymentType;
    private Boolean isPayed = false;
}

interface PaymentType{
    void pay();
}
class SelfPortalPay implements PaymentType{

    @Override
    public void pay() {

    }
}

class ParkingAttendantPay implements PaymentType{

    @Override
    public void pay() {

    }
}



// Services


class AdminService {

    void addFloor(ParkingLot parkingLot, Floor floor){
        List<Floor> floorList = parkingLot.getFloorList();
        if(floorList==null)
            floorList = new ArrayList<>();
        floorList.add(floor);
        parkingLot.setFloorList(floorList);
    }

    void removeFloor(ParkingLot parkingLot, int floorNo){
        List<Floor> floorList = parkingLot.getFloorList();
        floorList.remove(floorNo);
    }

    void assignParkingAttendantToGate(Gate gate, Attendant attendant) {
        gate.setAttendantId(attendant.getId());
        attendant.setGateId(gate.getId());
    }
}


abstract class ParkingLotService {

    abstract void fillSpot();

    abstract void emptySpot();
}


class  AttendantService {

    Ticket issueTicket(Vehicle vehicle) {


        return new Ticket();
    }

    void chargeParkingFee(Ticket ticket) {

    }

}

