package org.pogonin.hibernatetable;

import org.junit.jupiter.api.Test;
import org.pogonin.hibernatetable.entity.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class HibernateTableApplicationTests {

    @Autowired
    AircraftService aircraftService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void HibernateGetTest() {
        Aircraft aircraft = aircraftService.findById("773");
        System.out.println();
        System.out.println();
        System.out.println();
        var seat = aircraft.getSeats().stream().findFirst();
        System.out.println();
        System.out.println();
        System.out.println();
        var flight = aircraft.getFlight().stream().findFirst().get();
        System.out.println();
        System.out.println();
        System.out.println();
        var airport = flight.getArrivalAirport();
        System.out.println();
        System.out.println();
        System.out.println();
        var ticket = flight.getTickets().stream().findFirst().get();
        System.out.println();
        System.out.println();
        System.out.println();
        var booking = ticket.getBooking();
        System.out.println();
        System.out.println();
        System.out.println();
        var ticketFlight = ticket.getTicketFlights().stream().findFirst().get();
        System.out.println();
        System.out.println();
        System.out.println();
        var boardingPass = ticketFlight.getBoardingPasses();
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
