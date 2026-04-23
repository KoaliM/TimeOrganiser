package org.example.timeorganiser.model;
import jakarta.persistence.*;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "goals_and_tasks")
public class GoalsAndTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goals goals;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Tasks tasks;
}
