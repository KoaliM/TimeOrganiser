package org.example.timeorganiser.repository;

import dto.AssignmentDeadlineDTO;
import org.example.timeorganiser.model.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentsRepository extends JpaRepository<Assignments, Integer> {
    @Query("SELECT assignments.title AS urgent_assignments, TIMESTAMPDIFF(DAY,CURRENT_DATE(), assignments.due_date) AS days_left FROM assignments" +
            "GROUP BY assignments.title" +
            "ORDER BY days_left ASC" +
            "LIMIT 3")
    List<AssignmentDeadlineDTO> findUrgentAssignments();

    @Query("SELECT title FROM assignments" +
            "WHERE due_date >= :date")
    List<String> findAfterDate(@Param("date") Date date);

    @Query("SELECT assignments.title, TIMESTAMPDIFF(DAY,CURRENT_DATE(), assignments.due_date) AS days_left FROM assignments" +
            "GROUP BY assigments.title")
    List<AssignmentDeadlineDTO> findLeftTime();

}
