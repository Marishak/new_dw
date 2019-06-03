package com.spring.task.new_dw.service;

import com.spring.task.new_dw.entity.Ticket;
import com.spring.task.new_dw.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserService userService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, UserService userService) {
        this.ticketRepository = ticketRepository;
        this.userService = userService;
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).get();
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void addTicket(Ticket ticket, Long ownerId) {
        ticket.setOwner(userService.getUserById(ownerId));
        ticketRepository.save(ticket);
    }

    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }
}
