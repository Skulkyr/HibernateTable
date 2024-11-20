package org.pogonin.hibernatetable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_flights",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"ticket_no", "flight_id"})
        }
)
public class TicketFlight implements Serializable {

    @EmbeddedId
    TicketId ticketId;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no", insertable = false, updatable = false)
    private Ticket ticket;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id", insertable = false, updatable = false)
    private Flight flight;


    @OneToOne(mappedBy = "ticketFlight", cascade = CascadeType.ALL, orphanRemoval = true)
    private BoardingPass boardingPasses;
}
