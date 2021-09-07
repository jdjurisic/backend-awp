package com.example.backendawp.repository;

import com.example.backendawp.model.Company;
import com.example.backendawp.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Page<Ticket> findAllByOneway(Pageable pageable, boolean oneway);

    List<Ticket> findAllByCompanyId(Long id);

}
