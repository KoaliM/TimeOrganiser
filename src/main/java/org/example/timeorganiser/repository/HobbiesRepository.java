package org.example.timeorganiser.repository;

import org.example.timeorganiser.model.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobbies, Integer> {
}
