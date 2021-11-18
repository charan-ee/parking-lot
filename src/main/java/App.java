package main.java;

import main.java.Parking.*;
import main.java.vehicle.*;
import main.java.vehicle.VehicleType;

import java.util.*;

public class App {
    private static ParkingLot parkingLot;
    private static VehicleType type;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String input_command;
        String[] commands;
        List<Ticket> ticketList = new ArrayList<>();

        while (true) {
            input_command = input.nextLine();
            commands = input_command.split(" ");
            if (input_command.equals("exit")) {
                break;
            }
            switch (commands[0]) {
                case "create_parking_lot" -> {
                    parkingLot = new ParkingLot("PR1234", Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    System.out.println(parkingLot.toString());

                }
                case "display" -> {
                    if (commands[1].equals("free_count")) {
                        parkingLot.DisplayStatus(DisplayType.FREE_COUNT, VehicleType.valueOf(commands[2].toUpperCase()));

                    } else if (commands[1].equals("free_slots")) {
                        parkingLot.DisplayStatus(DisplayType.FREE_SLOTS, VehicleType.valueOf(commands[2].toUpperCase()));
                    } else if (commands[1].equals("occupied_slots")) {
                        parkingLot.DisplayStatus(DisplayType.OCCUPIED_SLOTS, VehicleType.valueOf(commands[2].toUpperCase()));
                    }
                }
                case "park_vehicle" -> {
                    if (commands[1].toUpperCase().equals("CAR")) {
                        Car car = new Car(commands[2], commands[3]);
                        var vehicleTicket = parkingLot.park(car);
                        ticketList.add(vehicleTicket);
                    } else if (commands[1].toUpperCase().equals("BIKE")) {
                        Bike bike = new Bike(commands[2], commands[3]);
                        var vehicleTicket = parkingLot.park(bike);
                        ticketList.add(vehicleTicket);
                    } else if (commands[1].toUpperCase().equals("TRUCK")) {
                        Truck truck = new Truck(commands[2], commands[3]);
                        var vehicleTicket = parkingLot.park(truck);
                        ticketList.add(vehicleTicket);
                        System.out.println(ticketList);
                    }
                }
                case "unpark_vehicle" -> {
                    Ticket ticketToRemove = null;
                    for (Ticket ticket : ticketList) {
                        if (ticket.getId().equals(commands[1])) {
                            ticketToRemove = ticket;
                        }
                    }
                    parkingLot.unPark(ticketToRemove);
                }
            }
        }
    }
}