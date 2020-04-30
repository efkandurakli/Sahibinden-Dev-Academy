package com.sahibinden.devakademi.dto.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertisementDTO {


    private Long id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Integer has_promotion;

    @NotNull
    private Integer view_count;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String town;


    private String c0;


    private String c1;


    private String c2;


    private String c3;


    private String c4;

    private String c5;


    private String c6;
}
