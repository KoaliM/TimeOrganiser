package org.example.timeorganiser.repository;

import org.example.timeorganiser.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> getUsers();

    Optional<Users> save(Users user);

}
