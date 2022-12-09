package com.example.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_car;

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "id_driver_fk")
    private Driver driver;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "car_mechanic",
            joinColumns = {@JoinColumn(name = "id_car_s")},
            inverseJoinColumns = {@JoinColumn(name = "id_mechanic_s")}
    )
    private List<Mechanic> mechanics;

}
