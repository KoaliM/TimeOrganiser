package org.example.timeorganiser.utils;

import org.example.timeorganiser.model.Users;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class UserSpecifications {
    public static Specification<Users> searchByFilters(String name, String city, String hobby) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Only add to the query if the parameter is not null/empty
            if (name != null && !name.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("username")), "%" + name.toLowerCase() + "%"));
            }

            if (city != null && !city.isEmpty()) {
                predicates.add(cb.equal(cb.lower(root.get("city")), city.toLowerCase()));
            }

            return cb.or(predicates.toArray(new Predicate[0]));
        };
    }
}
