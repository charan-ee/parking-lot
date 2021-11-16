package vehicle;

public abstract class Vehicle {
    private String registrationNumber;
    private VehicleType type;
    private String colour;

    public Vehicle(String registrationNumber, VehicleType type, String colour){
        this.registrationNumber = registrationNumber;
        this.type = type;
    }

    public VehicleType getVehicleType(){
        return this.type;
    }

};
