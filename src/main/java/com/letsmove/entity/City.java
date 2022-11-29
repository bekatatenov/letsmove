package com.letsmove.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "city")
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_seq")
    @SequenceGenerator(name = "city_id_seq", sequenceName = "city_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "CITY_NAME",unique = true)
    private String name;

    @Column(name = "POPULATION")
    private Integer population;

    @Lob
    @Column(name = "INFORMATION")
    private String information;

    @Column(name = "IMG")
    private String img;

    @Column(name = "CREATED_DATE")
    private Date createdDate;


}
