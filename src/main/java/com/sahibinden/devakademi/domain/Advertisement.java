package com.sahibinden.devakademi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "Advertisements")
public class Advertisement {

    @Id
    @Column(name = "ID")
    private Long id;


    @NotNull
    @NotEmpty
    private String title;



    @Column(length = 100000)
    private String description;


    private Double price;


    private Integer has_promotion;


    private Integer view_count;


    @Column(length = 100000)
    private String city;


    @Column(length = 100000)
    private String town;

    @Column(length = 100000)
    private String c0;

    @Column(length = 100000)
    private String c1;

    @Column(length = 100000)
    private String c2;

    @Column(length = 100000)
    private String c3;

    @Column(length = 100000)
    private String c4;

    @Column(length = 100000)
    private String c5;

    @Column(length = 100000)
    private String c6;




}
