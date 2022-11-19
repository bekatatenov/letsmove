package com.letsmove.letsmove.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "guides")
@Getter
@Setter
public class Guides {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guides_id_seq")
    @SequenceGenerator(name = "guides_id_seq", sequenceName = "guides_id_seq", allocationSize = 1)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User userID;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "NUMBER_PHONE")
    private String phoneNumber;

    @Column(name = "ALL_TOUR")
    private Integer allTour;

    @Column(name = "INFO")
    private String info;

    @Column(name = "IMG")
    private String img;
}
