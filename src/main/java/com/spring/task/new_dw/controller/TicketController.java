package com.spring.task.new_dw.controller;

import com.spring.task.new_dw.entity.Ticket;
import com.spring.task.new_dw.entity.User;
import com.spring.task.new_dw.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public void newTicket(@RequestBody Ticket ticket /*, @AuthenticationPrincipal User owner*/) {
//        ticket.setOwner(owner);
        ticketService.addTicket(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicketById(id);
    }

}
