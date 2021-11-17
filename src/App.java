import Parking.*;
import vehicle.*;
import vehicle.VehicleType;

import java.util.*;

public class App {
    public static void main(String[] args) {

        //Default Parking lot
        ParkingLot parkingLot=new ParkingLot("PR1234",2,6);

        parkingLot.DisplayStatus(DisplayType.FREE_COUNT,VehicleType.CAR);
        parkingLot.DisplayStatus(DisplayType.FREE_COUNT,VehicleType.BIKE);
//        parkingLot.DisplayStatus(DisplayType.FREE_COUNT,VehicleType.TRUCK);
//
        parkingLot.DisplayStatus(DisplayType.FREE_SLOTS,VehicleType.CAR);
//        parkingLot.DisplayStatus(DisplayType.FREE_SLOTS,VehicleType.BIKE);
//        parkingLot.DisplayStatus(DisplayType.FREE_SLOTS,VehicleType.TRUCK);

        parkingLot.DisplayStatus(DisplayType.OCCUPIED_SLOTS,VehicleType.CAR);
        parkingLot.DisplayStatus(DisplayType.OCCUPIED_SLOTS,VehicleType.BIKE);
        parkingLot.DisplayStatus(DisplayType.OCCUPIED_SLOTS,VehicleType.TRUCK);


        Car vehicle1=new Car("KA-01-DB-1234", "black");
        // vehicle1.setVehicleType(VehicleType.CAR);
        // vehicle1.setColor("black");
        // vehicle1.setRegNumber("KA-01-DB-1234");
        Bike vehicle2 = new Bike("KA-01-DB-1234", "red");

        List<Ticket> ticket=new ArrayList<>();
        for(Vehicle vehicle: List.of(vehicle1, vehicle2)){
            var temp=parkingLot.park(vehicle);
            ticket.add(temp);
            System.out.println(temp != null ? "Parked Successfully" + vehicle : "Park UnSuccessfull " + vehicle);
        }

        parkingLot.DisplayStatus(DisplayType.OCCUPIED_SLOTS,VehicleType.CAR);
        parkingLot.DisplayStatus(DisplayType.FREE_SLOTS,VehicleType.CAR);
        parkingLot.DisplayStatus(DisplayType.FREE_COUNT,VehicleType.BIKE);

        parkingLot.unPark(ticket.get(1));

        parkingLot.DisplayStatus(DisplayType.FREE_COUNT,VehicleType.CAR);
        parkingLot.DisplayStatus(DisplayType.FREE_COUNT,VehicleType.BIKE);
//        parkingLot.DisplayStatus(DisplayType.FREE_COUNT,VehicleType.TRUCK);

    }
}