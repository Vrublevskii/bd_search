package com.example.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_driver;

    @Column
    private String name_driver;

    @Column
    private String last_name_driver;

    @OneToMany(mappedBy = "driver")
    private List<Car> cars;

}
