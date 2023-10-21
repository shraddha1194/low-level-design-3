package com.learn.parkinglot.services;

import com.learn.parkinglot.dto.CreateTicketRequest;
import com.learn.parkinglot.exceptions.SlotNotAvailableException;
import com.learn.parkinglot.models.ParkingSpot;
import com.learn.parkinglot.models.SpotStatus;
import com.learn.parkinglot.models.Ticket;
import com.learn.parkinglot.models.Vehicle;
import com.learn.parkinglot.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;

    private TicketRepository ticketRepository;
    public Ticket createTicket(CreateTicketRequest request) {
        // Allocate a spot, if null throw an exception
        ParkingSpot parkingSpot = parkingSpotService.allocate(request.getParkingLotId(), request.getVehicleType());

        if (parkingSpot == null) {
            throw new SlotNotAvailableException(request.getVehicleType());
        }
        // Update the spot to Occupied and save it in DB
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        ParkingSpot allotedSpot = parkingSpotService.update(parkingSpot);

        // Fetch or create the vehicle (use vehicle number and type) else create new
        Vehicle vehicle = vehicleService.findOrCreateVehicle(request.getVehicleNumber(), request.getVehicleType());

        // Create a ticket and save it
        Ticket ticket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .parkingSpot(allotedSpot)
                .vehicle(vehicle)
                .entryGateId(request.getEntryGateId())
                .build();

        return ticketRepository.save(ticket);
    }
}
