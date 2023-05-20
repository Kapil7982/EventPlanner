package com.event.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String image;

    private String tagline;

    private LocalDateTime schedule;

    private String description;

    @ManyToOne
    private User moderator;

    private String category;

    private String subCategory;

    private int rigorRank;

    @ManyToMany
    private List<User> attendees;

}

