package com.letsmove.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments_place")
@Getter
@Setter
public class CommentsPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_place_id_seq")
    @SequenceGenerator(name = "comments_place_id_seq", sequenceName = "comments_place_id_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private Users usersID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PLACE_ID")
    private Place placeID;

    @Column(name = "COMMENT")
    private String comment;


    @Column(name = "CREATED_DATE")
    private Date createdDate;

}


