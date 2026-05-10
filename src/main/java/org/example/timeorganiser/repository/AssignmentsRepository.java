package org.example.timeorganiser.repository;

import org.example.timeorganiser.model.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentsRepository extends JpaRepository<Assignments, Integer> {
}
