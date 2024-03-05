package com.learn.parkinglot.services;

import com.learn.parkinglot.dto.CreateTicketRequest;
import com.learn.parkinglot.exceptions.NotFoundException;
import com.learn.parkinglot.exceptions.SlotNotAvailableException;
import com.learn.parkinglot.generators.TicketId;
import com.learn.parkinglot.models.*;
import com.learn.parkinglot.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;

    private TicketRepository ticketRepository;
    public Ticket createTicket(CreateTicketRequest request) {
        // Allocate a spot if null throw an exception
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
                .id(TicketId.nextId())
                .entryTime(LocalDateTime.now())
                .parkingSpot(allotedSpot)
                .vehicle(vehicle)
                .entryGateId(request.getEntryGateId())
                .build();

        return ticketRepository.save(ticket);
    }

    public Payment calculateAmount(Long id) {
        Ticket ticket = ticketRepository.findById(id);

        if (ticket == null) {
            throw new NotFoundException("Ticket with id: " + id + " not found in the system!!!");
        }

    }

    public Payment makePayment(Long id) {

    }
}
