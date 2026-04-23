package org.example.timeorganiser.model;
import enums.FriendRequests;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
 @Table(name = "friends")
 public class Friends {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long friendId;

     @ManyToOne
     @JoinColumn(name = "user_id")
     private Users user;

     @ManyToOne
     @JoinColumn(name = "friends_id")
     private Users friend;

     @Column(name = "status", unique = true, nullable = false)
     @Enumerated(EnumType.STRING)
     private FriendRequests connectionStatus;

     @Column(name = "time_of_friendship", unique = true, nullable = true)
     private LocalDateTime befriendedAt;
 }
