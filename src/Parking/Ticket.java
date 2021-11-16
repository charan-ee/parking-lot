package Parking;
import vehicle.Vehicle;

public class Ticket {
    private String id;
    private ParkingFloor floor;
    private ParkingSlot slot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setParkingFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    Ticket create(ParkingFloor floor,ParkingSlot slot,Vehicle vehicle){
        return new Ticket();
    }

}