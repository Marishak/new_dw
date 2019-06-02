package com.spring.task.new_dw.controller;

import com.spring.task.new_dw.entity.TicketType;
import com.spring.task.new_dw.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final TicketTypeService ticketTypeService;

    @Autowired
    public AdminController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @GetMapping
    public List<TicketType> getAllTicketTypes() {
        return ticketTypeService.getAllTicketTypes();
    }

    @GetMapping("/{id}")
    public TicketType getTicketTypeById(@PathVariable Long id) {
        return ticketTypeService.getTicketTypesById(id);
    }

    @PostMapping
    public void createTicketType(@RequestBody TicketType ticketType) {
        ticketTypeService.createTicketType(ticketType);
    }

    @DeleteMapping("/{id}")
    public void deleteTicketTypeById(@PathVariable Long id) {
        ticketTypeService.deleteById(id);
    }
}
