package Parking;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingSlot {
    private int slotId;
    private ParkingSlotType type;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private boolean isFree;

    public ParkingSlot(){
        isFree = true;
    }

    public ParkingSlot(int slotId, VehicleType type){
        this.slotId = slotId;
        this.vehicleType = type;
    }

    // public void assignVehicletoSlot(Vehicle vehicle){
    //     this.vehicle = vehicle;
    //     isFree = false;
    // }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    public void setOccupied(){
        isFree = false;
    }

    public boolean getStatus(){
        return isFree;
    }

    public String toString() {
        return "Slot{" +
                ", occupied=" + isFree +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
