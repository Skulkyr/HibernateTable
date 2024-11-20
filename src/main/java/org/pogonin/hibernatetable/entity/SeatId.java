package org.pogonin.hibernatetable.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Embeddable
@Data
public class SeatId implements Serializable {
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "aircraft_code", length = 3, nullable = false)
    private String aircraftCode;

    @Column(length = 4, nullable = false)
    private String seatNo;
}
