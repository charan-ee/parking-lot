package main.java.Parking;

import java.lang.reflect.Array;
import java.util.*;

import main.java.vehicle.Vehicle;
import main.java.vehicle.VehicleType;

public class ParkingLot {
    private List<ParkingFloor> floors;
    private String name;
    private Map<Ticket, Vehicle> tickets;
    private int slotsPerFloor;
    private int noOfFloors;

    public ParkingLot() {
    }

    public ParkingLot(String name, int floors, int slotsPerFloor) {
        this.floors = new ArrayList<ParkingFloor>();
        this.tickets = new HashMap<>();
        this.name = name;
        this.slotsPerFloor = slotsPerFloor;
        this.noOfFloors = floors;

        List<ParkingSlot> tempSlots;
        List<ParkingFloor> tempFloors = new ArrayList<ParkingFloor>();
        ParkingFloor floor;
        ParkingSlot slot;
        for (int i = 1; i <= floors; i++) {
            tempSlots = new ArrayList<ParkingSlot>();
            for (int j = 1; j <= slotsPerFloor; j++) {

                if (j == 1) {
                    slot = new ParkingSlot(j, VehicleType.TRUCK);
                } else if (j == 2 || j == 3) {
                    slot = new ParkingSlot(j, VehicleType.BIKE);
                } else {
                    slot = new ParkingSlot(j, VehicleType.CAR);
                }
                tempSlots.add(slot);
            }
            floor = new ParkingFloor(i, tempSlots);
            this.floors.add(floor);
        }

    }

    public String getName() {
        return name;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public int getSlotsPerFloor() {
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

    public Ticket park(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.getVehicleType() == vehicle.getVehicleType() && slot.getStatus()) {
                    slot.setOccupied();
                    Ticket ticket = new Ticket(floor, slot);
                    ticket.setId(this.name + "_" + floor.getFloor() + "_" + slot.getSlotId());
                    this.tickets.put(ticket, vehicle);
                    System.out.println("Parked Vehicle. Ticket ID: " + ticket.getId());
                    return ticket;
                }
            }
        }
        return null;
    }

    public boolean unPark(Ticket ticket) {
        if (tickets.containsKey(ticket)) {
            ticket.getSlot().setFree(true);
            Vehicle vehicle = tickets.get(ticket);
            System.out.println("Unparked vehicle with Registration Number: " + vehicle.getRegistrationNumber() + " and Color: " + vehicle.getColour());
            tickets.remove(ticket);
            return true;
        }
        return false;
    }


    public void DisplayStatus(DisplayType displayType, VehicleType vehicleType) {

        switch (displayType) {
            case FREE_COUNT -> {
                for (ParkingFloor floor : floors) {
                    int count = 0;
                    for (ParkingSlot slot : floor.getParkingSlots()) {
                        if (slot.getVehicleType() == vehicleType && slot.getStatus()) {
                            count++;
                        }
                    }
                    System.out.println("No. of free slots for " + vehicleType + " on Floor " + floor.getFloor() + ": " + count);
                }

            }
            case FREE_SLOTS -> {
                for (ParkingFloor floor : floors) {
                    ArrayList<Integer> tempFreeSlots = new ArrayList<>();
                    for (ParkingSlot slot : floor.getParkingSlots()) {
                        if (slot.getVehicleType() == vehicleType && slot.getStatus()) {
                            tempFreeSlots.add(slot.getSlotId());
                        }
                    }
                    System.out.println("Free slots for " + vehicleType + " on Floor " + floor.getFloor() + ": " + tempFreeSlots);
                }
            }
            case OCCUPIED_SLOTS -> {
                for (ParkingFloor floor : floors) {
                    ArrayList<Integer> tempOccupiedSlots = new ArrayList<>();
                    for (ParkingSlot slot : floor.getParkingSlots()) {
                        if (slot.getVehicleType() == vehicleType && slot.getStatus() == false) {
                            tempOccupiedSlots.add(slot.getSlotId());
                        }
                    }
                    System.out.println("Occupied slots for " + vehicleType + " on Floor " + floor.getFloor() + tempOccupiedSlots);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + displayType);
        }
    }

    public String toString() {
        return "Created parking lot with " + this.noOfFloors + " floors and " + this.slotsPerFloor + " slots per floor";
    }

}


