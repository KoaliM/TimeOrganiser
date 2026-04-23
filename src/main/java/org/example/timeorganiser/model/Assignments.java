package org.example.timeorganiser.model;

import enums.Status;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="assignments")
 public class Assignments{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentsId;

    @Column(name = "Title", unique = true, nullable = false)
    private String title;

    @Column(name = "AssignedUser", unique = true, nullable = false)
    private Long userId;

    @Column(name = "Due Date",unique = true, nullable = false)
    private Date dueDate;

    @Column(name = "Priority", unique = true, nullable = false)
    private int priority;

    @Column(name = "Status", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "assignment")
    private List<Tasks> tasks;
}