package com.spring.task.new_dw.service;

import com.spring.task.new_dw.entity.Ticket;
import com.spring.task.new_dw.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).get();
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByDate(LocalDate date) {
        return ticketRepository.findAllByDateTicket(date);
    }

    public List<Ticket> getPurchasedTickets() {
        return ticketRepository.findAllTicketsByOwnerNotNull();
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }
}
