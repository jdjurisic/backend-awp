package com.example.backendawp.controller;

import com.example.backendawp.model.Reservation;
import com.example.backendawp.model.Ticket;
import com.example.backendawp.model.User;
import com.example.backendawp.service.ReservationService;
import com.example.backendawp.service.TicketService;
import com.example.backendawp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    private final ReservationService reservationService;
    private final TicketService ticketService;
    private final UserService userService;

    public ReservationController(ReservationService reservationService, TicketService ticketService, UserService userService) {
        this.reservationService = reservationService;
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public List<Reservation> findAll(){ return reservationService.findAll(); }

    @GetMapping("/{ticketId}/{number}")
    public ResponseEntity<Boolean> reserveTickets(@PathVariable Long number, @PathVariable Long  ticketId){
        Optional<Ticket> t = ticketService.findById(ticketId);

        if(t.isPresent() && t.get().getCount() >= number){

            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            for(int i = 0; i < number; i++){
                Reservation res = new Reservation();
                res.setTicket(t.get());
                res.setUser(user);
                res.setFlight(t.get().getFlight());
                res.setIsAvailable(true);
                reservationService.save(res);
            }

            t.get().setCount(t.get().getCount() - number);
            ticketService.update(t.get().getId(),t.get());
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{resId}")
    public ResponseEntity<Boolean> cancelReservation(@PathVariable Long resId){

        Optional<Reservation> res = reservationService.findById(resId);
        Optional<Ticket> tick = ticketService.findById(res.get().getTicket().getId());

        if(res.isPresent()){

            reservationService.deleteById(resId);
            tick.get().setCount(tick.get().getCount() + 1);
            ticketService.update(tick.get().getId(), tick.get());
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }
}
