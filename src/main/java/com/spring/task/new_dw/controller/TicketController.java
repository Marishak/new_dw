package com.spring.task.new_dw.controller;

import com.spring.task.new_dw.entity.Ticket;
import com.spring.task.new_dw.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
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
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }

    @GetMapping("/bydate")
    public List<Ticket> getTicketByDate(LocalDate date) {
        return ticketService.getTicketsByDate(date);
    }

    @GetMapping("/purchased")
    public List<Ticket> getPurchasedTickets() {
        return ticketService.getPurchasedTickets();
    }

    @PostMapping
    public void addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
    }

    @DeleteMapping
    public void deleteTicket(@RequestBody Ticket ticket) {
        ticketService.deleteTicket(ticket);
    }

}
