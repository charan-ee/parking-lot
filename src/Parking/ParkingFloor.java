package Parking;
import java.util.*;

public class ParkingFloor {
    private int floor;
    private List<ParkingSlot> parkingSlots;

    ParkingFloor(){
    }

    public ParkingFloor(int floor, List<ParkingSlot> totalSlots) {
        this.floor = floor;
        this.parkingSlots = totalSlots;
    }

    public List<ParkingSlot> getParkingSlots(){
        return this.parkingSlots;
    }


}