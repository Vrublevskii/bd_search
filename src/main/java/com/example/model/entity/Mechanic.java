package com.example.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
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



}
