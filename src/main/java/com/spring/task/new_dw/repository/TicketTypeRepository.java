package com.spring.task.new_dw.repository;

import com.spring.task.new_dw.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

    List<TicketType> findAllByTicketDate(LocalDate date);
    List<TicketType> findAllByTicketDateAfter(LocalDate date);

}
