package com.letsmove.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history_tour")
@Getter
@Setter
public class HistoryTour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_tour_id_seq")
    @SequenceGenerator(name = "history_tour_id_seq", sequenceName = "history_tour_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private Users usersID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TOUR_ID")
    private Tour tourID;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

}