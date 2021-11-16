package Parking;
import java.util.*;
import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private String name;
    private Map<Ticket,Vehicle> tickets;

    public String getName() {
        return name;
    }
    public ParkingLot(){
    }

    public ParkingLot(String name,int floors,int slotPerFloor){
        this.tickets=new HashMap<>();
        this.name=name;
        ParkingSlot slot1=new ParkingSlot(1, VehicleType.TRUCK);
        ParkingSlot slot2=new ParkingSlot(2, VehicleType.BIKE);
        ParkingSlot slot3=new ParkingSlot(3, VehicleType.CAR);
        ParkingSlot slot4=new ParkingSlot(4, VehicleType.CAR);
        ParkingSlot slot5=new ParkingSlot(5, VehicleType.CAR);
        ParkingSlot slot6=new ParkingSlot(6, VehicleType.CAR);
        ParkingSlot slot7=new ParkingSlot(7, VehicleType.TRUCK);
        ParkingSlot slot8=new ParkingSlot(8, VehicleType.BIKE);
        ParkingSlot slot9=new ParkingSlot(9, VehicleType.CAR);
        ParkingSlot slot10=new ParkingSlot(10, VehicleType.CAR);
        ParkingSlot slot11=new ParkingSlot(11, VehicleType.CAR);
        ParkingSlot slot12=new ParkingSlot(12, VehicleType.CAR);
        ParkingFloor floor1=new ParkingFloor(1, List.of(slot1,slot2,slot3,slot4,slot5,slot6));
        ParkingFloor floor2=new ParkingFloor(2, List.of(slot7,slot8,slot9,slot10,slot11,slot12));
        this.floors=List.of(floor1,floor2);
    }
    
    public String toString() {
        return "ParkingLot{" +
                "floors=" + floors +
                ", name='" + name + '\'' +
                '}';
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

    public void DisplayStatus(DisplayType displayType, VehicleType vehicleType){

        switch (displayType){

            case FREE_COUNT -> {
                for(ParkingFloor floor:floors){
                    int count=0;
                    for(ParkingSlot slot:floor.getParkingSlots()){
                        if(slot.getVehicleType()==vehicleType && slot.getStatus()){
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
