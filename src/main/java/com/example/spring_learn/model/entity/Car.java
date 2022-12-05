package com.example.spring_learn.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String color;

    @Column
    private Integer year;

}
