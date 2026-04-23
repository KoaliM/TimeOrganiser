package org.example.timeorganiser.model;
import enums.Status;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignments assignment;

    @Column(name = "due_date", unique = true, nullable = true)
    private Date dueDate;

    @Column(name = "priority", unique = true, nullable = false)
    private int priority;

    @Column(name = "status", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "tasks")
    private List<GoalsAndTasks> goalsAndTasks;
}
