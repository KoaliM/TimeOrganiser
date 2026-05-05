package org.example.timeorganiser.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "desired_meetings")
public class DesiredMeetings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingsId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Users partner;

    @Column(name = "start time")
    private LocalDateTime startTime;

    @Column(name = "end time")
    private LocalDateTime endTime;
}
