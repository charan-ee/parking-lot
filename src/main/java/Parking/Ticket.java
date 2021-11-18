package main.java.Parking;
//import main.java.vehicle.Vehicle;

public class Ticket {
    private String id;
    private final ParkingFloor floor;
    private final ParkingSlot slot;

    public Ticket(ParkingFloor floor, ParkingSlot slot) {
        this.floor = floor;
        this.slot = slot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public ParkingFloor getFloor() {
//        return floor;
//    }

//    public void setParkingFloor(ParkingFloor floor) {
//        this.floor = floor;
//    }

    public ParkingSlot getSlot() {
        return slot;
    }

//    public void setSlot(ParkingSlot slot) {
//        this.slot = slot;
//    }

}