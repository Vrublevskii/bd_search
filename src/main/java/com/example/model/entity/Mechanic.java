package com.example.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_mechanic;

    @Column
    private String name_mechanic;

    @Column
    private String last_name_mechanic;

    @Column
    private Integer category_mechanic;

    @ManyToMany(mappedBy = "mechanics")
    private List<Car> cars;

}
