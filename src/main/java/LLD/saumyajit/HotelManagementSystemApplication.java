package LLD.saumyajit;

import java.util.List;

public class HotelManagementSystemApplication {

    public static void main(String[] args) {

    }

    class HotelManagementSystem{
        List<Room> roomsList;

    }
    class Room {

    }

    class Customer {
        String customerId;
        String name;
        String address;
    }


    abstract  class Account {
        String id;
    }
    class Admin extends Account {
        void addRoom(){}
        void editRoom(){}
        void deleteRoom(){}
    }

    class HouseKeeper extends Account{
        void updateHosueKeepingLogs(){}
    }
    class Recipionist extends Account {

    }


    /*
    Process
        - Identify the Actors and use cases
        - Draw use case diagram

        - Identify Entities and there relations. - Top - Down Approach

        - Then Jump into Creating Classes Focus on SOLID,DRY,KISS design principles + if possible we can apply any
        design patterns ( this should be least priority)


    */

}
