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
        city3.setName("Belgrade");

        City city4 = new City();
        city4.setName("Liverpool");

        City city5 = new City();
        city5.setName("Madrid");

        City city6 = new City();
        city6.setName("Berlin");

        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);
        cityRepository.save(city4);
        cityRepository.save(city5);
        cityRepository.save(city6);

        // create companies
        Company comp1 = new Company();
        comp1.setName("Wizz Air");

        Company comp2 = new Company();
        comp2.setName("Easy Jet");

        Company comp3 = new Company();
        comp3.setName("Air Serbia");

        Company comp4 = new Company();
        comp4.setName("Qatar Airways");

        Company comp5 = new Company();
        comp5.setName("Swiss Air");

        Company comp6 = new Company();
        comp6.setName("Turkish Airlines");

        companyRepository.save(comp1);
        companyRepository.save(comp2);
        companyRepository.save(comp3);
        companyRepository.save(comp4);
        companyRepository.save(comp5);
        companyRepository.save(comp6);

        // create flights
        Flight flight1 = new Flight();
        flight1.setDestination(city1);
        flight1.setOrigin(city2);

        Flight flight2 = new Flight();
        flight2.setDestination(city3);
        flight2.setOrigin(city1);

        Flight flight3 = new Flight();
        flight3.setDestination(city5);
        flight3.setOrigin(city2);

        Flight flight4 = new Flight();
        flight4.setDestination(city6);
        flight4.setOrigin(city2);

        Flight flight5 = new Flight();
        flight5.setDestination(city5);
        flight5.setOrigin(city6);

        Flight flight6 = new Flight();
        flight6.setDestination(city4);
        flight6.setOrigin(city3);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);
        flightRepository.save(flight5);
        flightRepository.save(flight6);


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

        Ticket ticket3 = new Ticket();
        ticket3.setCompany(comp1);
        ticket3.setCount(99L);
        ticket3.setFlight(flight1);
        ticket3.setOneway(true);
        ticket3.setDepartureDate(new Date());

        Ticket ticket4 = new Ticket();
        ticket4.setCompany(comp2);
        ticket4.setCount(59L);
        ticket4.setFlight(flight2);
        ticket4.setOneway(false);
        ticket4.setDepartureDate(new Date());
        ticket4.setReturnDate(new Date());

        Ticket ticket5 = new Ticket();
        ticket5.setCompany(comp1);
        ticket5.setCount(99L);
        ticket5.setFlight(flight1);
        ticket5.setOneway(true);
        ticket5.setDepartureDate(new Date());

        Ticket ticket6 = new Ticket();
        ticket6.setCompany(comp2);
        ticket6.setCount(59L);
        ticket6.setFlight(flight2);
        ticket6.setOneway(false);
        ticket6.setDepartureDate(new Date());
        ticket6.setReturnDate(new Date());

        Ticket ticket7 = new Ticket();
        ticket7.setCompany(comp1);
        ticket7.setCount(99L);
        ticket7.setFlight(flight1);
        ticket7.setOneway(true);
        ticket7.setDepartureDate(new Date());

        Ticket ticket8 = new Ticket();
        ticket8.setCompany(comp2);
        ticket8.setCount(59L);
        ticket8.setFlight(flight2);
        ticket8.setOneway(false);
        ticket8.setDepartureDate(new Date());
        ticket8.setReturnDate(new Date());

        Ticket ticket9 = new Ticket();
        ticket9.setCompany(comp1);
        ticket9.setCount(99L);
        ticket9.setFlight(flight1);
        ticket9.setOneway(true);
        ticket9.setDepartureDate(new Date());

        Ticket ticket10 = new Ticket();
        ticket10.setCompany(comp2);
        ticket10.setCount(59L);
        ticket10.setFlight(flight2);
        ticket10.setOneway(false);
        ticket10.setDepartureDate(new Date());
        ticket10.setReturnDate(new Date());

        Ticket ticket11 = new Ticket();
        ticket11.setCompany(comp1);
        ticket11.setCount(99L);
        ticket11.setFlight(flight1);
        ticket11.setOneway(true);
        ticket11.setDepartureDate(new Date());

        Ticket ticket12 = new Ticket();
        ticket12.setCompany(comp2);
        ticket12.setCount(59L);
        ticket12.setFlight(flight2);
        ticket12.setOneway(false);
        ticket12.setDepartureDate(new Date());
        ticket12.setReturnDate(new Date());

        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);
        ticketRepository.save(ticket3);
        ticketRepository.save(ticket4);
        ticketRepository.save(ticket5);
        ticketRepository.save(ticket6);
        ticketRepository.save(ticket7);
        ticketRepository.save(ticket8);
        ticketRepository.save(ticket9);
        ticketRepository.save(ticket10);
        ticketRepository.save(ticket11);
        ticketRepository.save(ticket12);


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
