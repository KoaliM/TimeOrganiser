package org.example.timeorganiser.repository;

import org.example.timeorganiser.model.DesiredMeetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetRepository extends JpaRepository<DesiredMeetings, Integer> {
}
