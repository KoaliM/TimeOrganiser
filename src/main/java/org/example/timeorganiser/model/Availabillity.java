package org.example.timeorganiser.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "availability")
public class Availabillity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "start_time", unique = true, nullable = true)
    private Date startTime;

    @Column(name = "end_time", unique = true, nullable = true)
    private Date endTime;
}
