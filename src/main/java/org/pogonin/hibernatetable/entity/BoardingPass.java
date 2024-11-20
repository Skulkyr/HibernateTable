package org.pogonin.hibernatetable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "boarding_passes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"flight_id", "boarding_no"}),
                @UniqueConstraint(columnNames = {"flight_id", "seat_no"})
        })
public class BoardingPass implements Serializable {
    @EmbeddedId
    TicketId ticketId;

    @Column(name = "boarding_no", nullable = false)
    private int BoardingNo;

    @Column(name = "seat_no", length = 4, nullable = false)
    private String seatNo;

    @OneToOne(optional = false)
    @MapsId("ticketId")
    @JoinColumns({
            @JoinColumn(name = "ticket_no", referencedColumnName = "ticket_no", insertable = false, updatable = false),
            @JoinColumn(name = "flight_id", referencedColumnName = "flight_id", insertable = false, updatable = false)
    })
    private TicketFlight ticketFlight;
}
