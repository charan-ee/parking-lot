package Parking;
import java.util.*;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingLot {
    private List<ParkingFloor> floors = null;
    private String name;
    private Map<Ticket,Vehicle> tickets;
    private int slotsPerFloor;
    private int noOfFloors;

    ParkingLot(){
    }


    public ParkingLot(String name,int floors,int slotsPerFloor){
//        this.floors = new ArrayList<ParkingFloor>();
        this.tickets=new HashMap<>();
        this.name=name;
        this.slotsPerFloor = slotsPerFloor;
        this.noOfFloors = floors;

        List<ParkingSlot> tempSlots = new ArrayList<ParkingSlot>();
        List<ParkingFloor> tempFloors = new ArrayList<ParkingFloor>();

        for(int i=1; i<=floors; i++){
            ParkingFloor floor;
            for(int j=1; j <= slotsPerFloor; j++){
                ParkingSlot slot;
                if(j == 1){
                    slot = new ParkingSlot(j, VehicleType.TRUCK);
                }
                else if(j == 2 || j == 3){
                    slot = new ParkingSlot(j, VehicleType.BIKE);
                }else {
                    slot = new ParkingSlot(j, VehicleType.CAR);
                }
                tempSlots.add(slot);
            }
            floor = new ParkingFloor(i, tempSlots);
            tempFloors.add(floor);
        }
        this.floors = tempFloors;
    }

    public String getName() {
        return name;
    }

    public int getNoOfFloors(){
        return noOfFloors;
    }

    public int getSlotsPerFloor(){
        return slotsPerFloor;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getParkingFloors() {
        return floors;
    }

    public void setParkingFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public Ticket park(Vehicle vehicle){
        for(ParkingFloor floor:floors){
            for(ParkingSlot slot: floor.getParkingSlots()){
                if(slot.getVehicleType()==vehicle.getVehicleType() && slot.getStatus()){
                    slot.setOccupied();
                    Ticket ticket=new Ticket();
                    ticket.setParkingFloor(floor);
                    ticket.setSlot(slot);
                    ticket.setId(this.name+vehicle+slot+floor);

                    this.tickets.put(ticket,vehicle);
                    return ticket;
                }
            }
        }
        return null;
    }

    public boolean unPark(Ticket ticket){
        if(tickets.containsKey(ticket)){
            ticket.getSlot().setOccupied();
            tickets.remove(ticket);
            return true;
        }
        return false;
    }

    public String toString(){
        return "Created parking lot with " + this.noOfFloors + " floors and " + this.slotsPerFloor + " slots per floor";
    }

    public void DisplayStatus(DisplayType displayType, VehicleType vehicleType){

        switch (displayType){

            case FREE_COUNT -> {
                for(ParkingFloor floor:floors){
                    int count=0;
                    for(ParkingSlot slot:floor.getParkingSlots()){
                        if(slot.getVehicleType()==vehicleType && slot.getStatus() == true){
                            count++;
                        }
                    }
                    System.out.println(" ParkingFloor with "+vehicleType+" has "+count+" free slots");
                }

            }
            case FREE_SLOTS -> {
                for(ParkingFloor floor:floors){
                    for(ParkingSlot slot:floor.getParkingSlots()){
                        if(slot.getVehicleType()==vehicleType && slot.getStatus()){
                            System.out.println("ParkingFloor with "+vehicleType+" has "+ slot+ " free");
                        }
                    }
                }
            }
            case OCCUPIED_SLOTS -> {
                for(ParkingFloor floor:floors){
                    for(ParkingSlot slot:floor.getParkingSlots()){
                        if(slot.getVehicleType()==vehicleType && !slot.getStatus()){
                            System.out.println("ParkingFloor with "+vehicleType+" has "+ slot+ " occupied");
                        }
                    }
                }
            }

            default -> throw new IllegalStateException("Unexpected value: " + displayType);
        }

    }

}
