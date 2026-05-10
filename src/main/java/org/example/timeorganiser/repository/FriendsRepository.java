package org.example.timeorganiser.repository;

import org.example.timeorganiser.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Integer> {
}
