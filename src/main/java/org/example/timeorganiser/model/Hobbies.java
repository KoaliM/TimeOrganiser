package org.example.timeorganiser.model;
import jakarta.persistence.*;

@Entity
@Table(name = "hobbies")
public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobbyId;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "occurence_per_week", unique = true, nullable = false)
    private int occurencePerWeek;

    @Column(name = "priority", unique = true, nullable = false)
    private int priority;
}
