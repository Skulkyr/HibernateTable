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
@Table(name = "seats")
public class Seat implements Serializable {
    @EmbeddedId
    private SeatId seatId;

    @Column(name = "fare_conditions", columnDefinition = "VARCHAR(10) NOT NULL")
    @Enumerated(EnumType.STRING)
    private FareCondition fareConditions;
}
