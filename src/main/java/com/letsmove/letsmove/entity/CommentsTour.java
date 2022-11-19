package com.letsmove.letsmove.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments_tour")
@Getter
@Setter
public class CommentsTour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_tour_id_seq")
    @SequenceGenerator(name = "comments_tour_id_seq", sequenceName = "comments_tour_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User userID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TOUR_ID")
    private Tour tourID;

    @Column(name = "COMMENT")
    private String comment;


    @Column(name = "CREATED_DATE")
    private Date createdDate;

}
