package org.example.timeorganiser.controllers;

import org.example.timeorganiser.model.Users;
import org.example.timeorganiser.services.UserService;
import org.example.timeorganiser.utils.UserSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Users>> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) int minAge,
            @RequestParam(required = false) int maxAge,
            @RequestParam(required=false) Date startTime,
            @RequestParam(required = false) Date endTime) {

        if (name == null && city == null && startTime == null && endTime == null && minAge == 0 && maxAge==0) {
            return ResponseEntity.ok(userRepository.findAll());
        }

        Specification<Users> spec = UserSpecifications.searchByFilters(name, city, startTime, endTime, minAge, maxAge);
        return ResponseEntity.ok(userRepository.findAll(spec));
    }
}
