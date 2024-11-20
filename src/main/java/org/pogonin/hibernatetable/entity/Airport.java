package org.pogonin.hibernatetable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "airports")
public class Airport implements Serializable {
    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(name = "airport_code", length = 3, nullable = false, updatable = false)
    private String airportCode;

    @Column(name = "airport_name", nullable = false, columnDefinition = "text")
    private String airportName;

    @Column(nullable = false, columnDefinition = "text")
    private String city;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false, columnDefinition = "text")
    private String timezone;

}
