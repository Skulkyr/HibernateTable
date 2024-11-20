package org.pogonin.hibernatetable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket implements Serializable {
    @Id
    @Column(name = "ticket_no", length = 13, nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    private String ticketNo;

    @Column(name ="book_ref", length = 6, nullable = false)
    @JdbcTypeCode(SqlTypes.CHAR)
    private String bookRef;

    @Column(name = "passenger_id", length = 20, nullable = false)
    private String passengerId;

    @Column(name = "passenger_name", columnDefinition = "TEXT NOT NULL")
    private String passengerName;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "contact_data", columnDefinition = "JSONB")
    private Map<String, Object> contactData;

    @ManyToMany
    @JoinTable(
            name = "ticket_flights",
            joinColumns = @JoinColumn(name = "ticket_no"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private Set<Flight> flights;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_ref", insertable = false, updatable = false)
    private Booking booking;

    @OneToMany(mappedBy = "ticket")
    private Set<TicketFlight> ticketFlights;
}
