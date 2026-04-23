package org.example.timeorganiser.model;

import enums.Status;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "target_date", unique = true, nullable = true)
    private Date targetDate;

    @Column(name = "priority", unique = true, nullable = false)
    private int priority;

    @Column(name = "status", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "goals")
    private List<GoalsAndTasks> goalsAndTasks;
}
