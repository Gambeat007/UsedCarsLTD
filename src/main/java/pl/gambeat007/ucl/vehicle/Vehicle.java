package pl.gambeat007.ucl.vehicle;

import lombok.*;
import pl.gambeat007.ucl.model.UCLBase;

import javax.persistence.*;

/**
 * This is a model class for company vehicles
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vehicles")
public class Vehicle extends UCLBase {

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "prod_year")
    private int prodYear;

    @Column(name = "price")
    private double price;

    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
}
