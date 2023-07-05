package LLD.conceptandcoding.carrental;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




// Models

@Data
class User {
    String id;
    String name;
    String address;
    String drivingLicenseId;
}

@Data
class Store {
    String id;
    Location Location;
    List<Vehicle> vehiclesList;
}

@Data
class Location{
    int x,y;
}

@Data
abstract class Vehicle {
    String id;
    String name;
    String model;
    int costPerHour;
    int costPerDay;
    VehicleType vehicleType;
    VehicelStatus vehicelStatus;
}

@Data
class Car extends Vehicle {

}

@Data
class Bike extends Vehicle {

}

enum VehicleType{
    CAR,BIKE;
}

enum VehicelStatus{
    AVAILABLE, SCHEDULED, PICKED, CANCELED, COMPLETED;
}

@Data
class Reservation {
    String vehicleId;
    String userId;
    String pickedUpTime;
    String completedTime;
    Bill bill;
}

@Data
class Bill {
    int amountToBePayed;
    boolean paymentDone;
}

@Data
class Platform{
    List<User> users;
    List<Store> stores;
    List<Reservation> reservations;
}


// Services
@Data
class UserService{


}

class VehicleService{

    private StoreService storeService;

    void addVehicle(String storeId, Vehicle vehicle){
        Store store = storeService.getStore(storeId);
        List<Vehicle> vehicles = store.getVehiclesList();
        vehicles.add(vehicle);
        store.setVehiclesList(vehicles);
    }

    void removeVehicle(String storeId, Vehicle vehicle){
        Store store = storeService.getStore(storeId);
        List<Vehicle> vehicles = store.getVehiclesList();
        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getId().equals(vehicle.getId())){
                iterator.remove();
                break;
            }
        }
        store.setVehiclesList(vehicles);
    }

}

class StoreService{

    private PlatformService platformService;

    Store getStore(String id){
        List<Store> stores = platformService.getStores();
        Store store = stores.stream().filter((e)->e.getId().equals(id)).findAny().orElse(null);
        return store;
    }

}

class PlatformService {

    Platform platform = new Platform();
    void addUser( User user){
        List<User> users = platform.getUsers();
        users.add(user);
        platform.setUsers(users);
    }

    void deleteUser(String id){
        List<User> users = platform.getUsers();
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        platform.setUsers(users);
    }

    List<Store> getStores(){
        return platform.getStores();
    }

    List<User> getUsers(){
        return platform.getUsers();
    }
}


public class CarRental {

    public static void main(String[] args) {

        Platform platform = new Platform();
        List<User> users = new ArrayList<>();

        PlatformService platformService = new PlatformService();

        UserService userService = new UserService();
        VehicleService vehicleService  = new VehicleService();
        StoreService storeService = new StoreService();

    }


}



