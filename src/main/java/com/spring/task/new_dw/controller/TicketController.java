package com.spring.task.new_dw.controller;

import com.spring.task.new_dw.entity.Ticket;
import com.spring.task.new_dw.service.TicketService;
import com.spring.task.new_dw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllTickets(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        model.addAttribute("users", userService.getAllUser());
        return "ticket";
    }

    @GetMapping("/add")
    public String buyTicket(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "addTicket";
    }


    @GetMapping("/user")
    public String getAllTicketsByUser(@RequestParam Long id, Model model) {
        List<Ticket> tickets = ticketService.getAllTicketsByOwnerId(id);
        model.addAttribute("tickets", tickets);
        model.addAttribute("users", userService.getAllUser());
        return "ticket";
    }

    @PostMapping("/add")
    public String newTicket(@RequestParam Long ownerId,
                            @RequestParam String ticketDate,
                            @RequestParam Double price) {

        Ticket ticket = new Ticket();
        ticket.setOwner(userService.getUserById(ownerId));
        ticket.setPrice(price);
        ticket.setTicketDate(LocalDate.parse(ticketDate));
        ticketService.addTicket(ticket);

        return "redirect:/ticket/all";
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicketById(id);
        return "redirect:/ticket/all";
    }

}
