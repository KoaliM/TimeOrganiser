package org.example.timeorganiser.repository;

import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.model.Users;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository extends JpaSpecificationExecutor<Users, Integer> {
    List<Users> getUsers();

    Options<Users> save()

}
