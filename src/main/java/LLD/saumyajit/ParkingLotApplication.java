package LLD.saumyajit;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class ParkingLotApplication {

    public static void main(String[] args) {

        ParkingLotApplication app = new ParkingLotApplication();
        app.run();

    }

    void run(){
        Account admin = new Admin();
        ParkingLot parkingLot = new ParkingLot();


    }



    @Data
    class ParkingLot {

        ParkingLot parkingLot = new ParkingLot();

        private List<Floor> floors;

        ParkingLot ParkingLot(){
            if(parkingLot!=null)
                return parkingLot;
            parkingLot = new ParkingLot();
            return parkingLot;
        }
    }

    @Data
    class Spot{
        VehicleInfo vehicleInfo;
    }
    @Data
    class TwoWheelerSpot extends Spot{

    }
    @Data
    class FourWheelerSpot extends Spot{

    }


    class Gate {

    }
    class EntranceGate extends Gate {

    }
    class ExitGate extends Gate {

    }

    @Data
    class Floor {
        private List<Gate> entranceGate;
        private List<Gate> exitGate;
        private DisplayBoard displayBoard;
        private List<Spot> twoWheelerSpots;
        private List<Spot> fourWheelerSpots;

    }
    class ParkingTicket {
        VehicleInfo  vehicleInfo;
    }

    @Data
    class Account {
        String name;
        String Address;
    }
    @Data
    @NoArgsConstructor
    class Admin extends Account {


        void addFloors(ParkingLot parkingLot){
            Floor floor = new Floor();

            parkingLot.getFloors().add(floor);
        }
    }
    @Data
    class Attendant extends Account {

    }


    @Data
    class VehicleInfo {
        private String vehicleNo;
        private String vehicleColor;
    }

    @Data
    class DisplayBoard{
        private int emptyTwoWheelerSlots;
        private int emptyFourWheelerSlots;
        private int emptyTruckSlots;

    }




}








// Entities

/*

    Parkign Lot
        - List<Floor> floors


    Floor
        - List<Gate> entraceGate
        - List<Gate> exitGate
        - DisplayBoard
        - List<Spot> twoWheeler
        - List<Spot> fourWheeler
        - List<Spot> trucks

    Gate
        - ParkingAttendant

    ExitGate extends Gate
        -

    EnteranceGate extends Gate
        -

    ParkingTicket
        - Vehicle Info
        - EnteranceTime
        - ExitTime
        - PaymentType
        - Price



    Admin
        - addFloor()
        - chancePrice()
        -

 */


