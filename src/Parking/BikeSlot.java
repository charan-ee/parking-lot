package Parking;

import vehicle.Bike;

public class BikeSlot extends ParkingSlot{
    public BikeSlot(String slotId){
        super(slotId, ParkingSlotType.BIKE);
    }
}
