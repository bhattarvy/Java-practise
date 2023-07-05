package LLD.conceptandcoding.elevator;

import lombok.Data;

public class Elevator {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.run();

        //System.out.println(String.valueOf(null));
    }

    void run(){
        Car car = new Car();
        System.out.println(String.valueOf(car.getName())
                           + " " + String.valueOf(car.getX()));
    }
}

@Data
class Car {
    private String name;
    private  int x;
}