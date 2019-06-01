package com.spring.task.new_dw.repository;

import com.spring.task.new_dw.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByDateTicket(LocalDate date);

    List<Ticket> findAllTicketsByOwnerNotNull();


}
