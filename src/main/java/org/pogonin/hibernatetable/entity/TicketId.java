package org.pogonin.hibernatetable.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Embeddable
@Data
public class TicketId implements Serializable {
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "ticket_no", length = 13, nullable = false)
    private String ticketNo;
    @Column(name = "flight_id", nullable = false)
    private int flightId;
}
