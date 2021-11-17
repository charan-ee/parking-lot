package Parking;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingSlot {
    private int slotId;
    private ParkingSlotType type;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private boolean isFree = true;

    public ParkingSlot(int slotId, VehicleType type){
        this.slotId = slotId;
        this.vehicleType = type;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    public void setOccupied(){
        this.isFree = false;
    }

    public void setFree(boolean status){
        this.isFree = status;
    }

    public boolean getStatus(){
        return isFree;
    }

    public int getSlotId(){
        return slotId;
    }

}
