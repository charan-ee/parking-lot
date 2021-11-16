package Parking;

public class TruckSlot extends ParkingSlot {
    public TruckSlot(String slotId){
        super(slotId, ParkingSlotType.TRUCK);
    }
}
