package com.letsmove.entity;

import com.letsmove.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tours")
@Getter
@Setter
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tours_id_seq")
    @SequenceGenerator(name = "tours_id_seq", sequenceName = "tours_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "TOUR_NAME")
    private String nameTour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GUIDES_ID")
    private Guides guidesID;

    @Lob
    @Column(name = "INFO")
    private String info;

    @Column(name = "IMG")
    private String img;

    @Column(name = "VISITORS")
    private Integer visitors;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING )
    private Status status;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

}

