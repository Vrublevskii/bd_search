package com.example.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
