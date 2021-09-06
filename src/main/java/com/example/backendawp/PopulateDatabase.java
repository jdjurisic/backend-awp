package com.example.backendawp;

import com.example.backendawp.model.*;
import com.example.backendawp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PopulateDatabase implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        String encrp1 = passwordEncoder.encode("Sifra123");

        // create users
        User user1 = new User();
        user1.setUsername("Korisnik");
        user1.setPassword(encrp1);
        user1.setType(UserType.USER);

        User user2 = new User();
        user2.setUsername("Admin");
        user2.setPassword(encrp1);
        user2.setType(UserType.ADMIN);

        userRepository.save(user1);
        userRepository.save(user2);


        // create cities
        City city1 = new City();
        city1.setName("Starcevo");

        City city2 = new City();
        city2.setName("Basel");

        City city3 = new City();
        city3.setName("Beograd");

        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);

        // create companies
        Company comp1 = new Company();
        comp1.setName("Wizz Air");

        Company comp2 = new Company();
        comp2.setName("Easy Jet");

        Company comp3 = new Company();
        comp3.setName("Air Serbia");

        companyRepository.save(comp1);
        companyRepository.save(comp2);
        companyRepository.save(comp3);

        // create flights
        Flight flight1 = new Flight();
        flight1.setDestination(city1);
        flight1.setOrigin(city2);

        Flight flight2 = new Flight();
        flight2.setDestination(city3);
        flight2.setOrigin(city1);

        flightRepository.save(flight1);
        flightRepository.save(flight2);


        // create tickets
        Ticket ticket1 = new Ticket();
        ticket1.setCompany(comp1);
        ticket1.setCount(99L);
        ticket1.setFlight(flight1);
        ticket1.setOneway(true);
        ticket1.setDepartureDate(new Date());

        Ticket ticket2 = new Ticket();
        ticket2.setCompany(comp2);
        ticket2.setCount(59L);
        ticket2.setFlight(flight2);
        ticket2.setOneway(false);
        ticket2.setDepartureDate(new Date());
        ticket2.setReturnDate(new Date());

        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);

        // create reservations
        Reservation res1 = new Reservation();
        res1.setFlight(flight1);
        res1.setIsAvailable(true);
        res1.setTicket(ticket1);
        res1.setUser(user1);

        Reservation res2 = new Reservation();
        res2.setFlight(flight2);
        res2.setIsAvailable(false);
        res2.setTicket(ticket2);
        res2.setUser(user1);

        reservationRepository.save(res1);
        reservationRepository.save(res2);

    }
}
