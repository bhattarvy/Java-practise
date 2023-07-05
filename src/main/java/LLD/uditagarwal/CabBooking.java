package LLD.uditagarwal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CabBooking {




}


// Models

@Getter
@AllArgsConstructor
class Rider {
    private String riderId;
    private String name;
    private String emailId;
    List<Trip> tripList;

}

@Data
@AllArgsConstructor
class Cab {
    private String driverId;
    private String driverName;
    private String emailId;
    private Location currentLocation;
    private TripStatus tripStatus;
    private boolean isAvailable;
    private List<Trip> tripList;

}

enum TripStatus{
    IN_PROGRESS,
    NOT_STARTED;
}

class Trip{
    private Location startLocation;
    private Location endLocation;
    private int price;
    private String driverId;
}

@Data
class Location {
    private int x;
    private int y;
}



// Services
@Slf4j
class RiderService {

    List<Rider> riderList;

    void registerRider(Rider rider){
        if (riderList.stream().filter((e) -> {
            return e.getEmailId().equals(rider.getEmailId());
        }).findAny().orElse(null) != null) {
            log.info("Rider is already registered");
        }
        riderList.add(rider);
    }


}

@Slf4j
class CabService {
    List<Cab> cabList;

    void registerCab(Cab cab){
        if(cabList.stream().filter((e)->e.getEmailId().equals(cab.getEmailId())).findAny().orElse(null)!=null){
            log.info("cab is empty");
        }
        cabList.add(cab);
    }

    List<Cab> searchCab(Location riderLocation){
        List<Cab> cabs = cabList.stream().filter((e)-> e.isAvailable()).collect(Collectors.toList());
        Collections.sort(cabs,(o1,o2)->{
            return (int) (Math.sqrt((o1.getCurrentLocation().getX() - riderLocation.getX()) * (o1.getCurrentLocation().getX() - riderLocation.getX()) +
                                         (o1.getCurrentLocation().getY()-riderLocation.getY())*((o1.getCurrentLocation().getY()-riderLocation.getY()))) -
                                      Math.sqrt((o2.getCurrentLocation().getX()-riderLocation.getX())*(o2.getCurrentLocation().getX()-riderLocation.getX()) +
                                         (o2.getCurrentLocation().getY()-riderLocation.getY())*((o2.getCurrentLocation().getY()-riderLocation.getY()))));
        });
        return cabs;
    }

}


@Slf4j
class TripService {

}

