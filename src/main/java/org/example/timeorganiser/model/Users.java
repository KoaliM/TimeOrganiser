package org.example.timeorganiser.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "password")

    @Column(name = "timezone", unique = true, nullable = false)
    private String timezone;

    @Column(name =  "city", unique = true, nullable = false)
    private String city;

    @OneToMany(mappedBy = "user")
    private List<Friends> friendships;

    @OneToMany(mappedBy = "user")
    private List<Availabillity> availableTime;

    @OneToMany(mappedBy = "user")
    private List<Goals> goals;

    @OneToMany(mappedBy = "user")
    private List<Tasks> tasks;

    @OneToMany(mappedBy = "partner")
    private List<DesiredMeetings> partner;

    @OneToMany(mappedBy = "user")
    private List<Hobbies> hobbies;

    public void setUsersname(String username) {
        this.name = username;
    }
}
