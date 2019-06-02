package com.spring.task.new_dw.service;

import com.spring.task.new_dw.entity.TicketType;
import com.spring.task.new_dw.exception.BadRequestException;
import com.spring.task.new_dw.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService {
    private final TicketTypeRepository ticketTypeRepository;

    @Autowired
    public TicketTypeService(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;

    }


    public List<TicketType> getAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }

    public TicketType getTicketTypesById(Long id) {
        return ticketTypeRepository.findById(id).get();
    }

    public void createTicketType(TicketType ticketType) {
        if (ticketType.getId() != null)
            throw new BadRequestException("Ticket type already exist");
        ticketTypeRepository.save(ticketType);
    }

    public void deleteById(Long id) {
        ticketTypeRepository.deleteById(id);
    }
}
