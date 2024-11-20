package org.pogonin.hibernatetable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aircrafts")
public class Aircraft implements Serializable {

    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "aircraft_code", length = 3, nullable = false)
    private String aircraftCode;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String model;

    @Column(nullable = false)
    private Integer range;

    @OneToMany(mappedBy = "aircraft", orphanRemoval = true)
    private Set<Flight> flight;

    @OneToMany
    @JoinColumn(name = "aircraft_code")
    private Set<Seat> seats;
}
