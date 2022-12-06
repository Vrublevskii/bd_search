package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
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

}
