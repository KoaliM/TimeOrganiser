package org.example.timeorganiser.repository;

import dto.MeetDTO;
import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.model.DesiredMeetings;
import org.example.timeorganiser.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetRepository extends JpaRepository<DesiredMeetings, Integer> {
    @Query("SELECT COUNT(DesiredMeetings.partner) FROM DesiredMeetings WHERE DesiredMeetings.user = :user")
    int countDesiredMeetingsByUser(Users user);

    @Query("SELECT Users.name FROM Users INNER JOIN DesiredMeetings ON Users.user = DesiredMeetings.user WHERE DesiredMeetings.user = :user")
    List<MeetDTO> findMeetsByUser(Users user);
}
