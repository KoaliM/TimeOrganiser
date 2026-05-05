package org.example.timeorganiser.controllers;

import dto.MeetDTO;
import org.example.timeorganiser.services.MeetService;
import org.example.timeorganiser.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/meet")
public class MeetController {
    private final MeetService meetService;
    private final UserService userService;

    public MeetController(MeetService meetService, UserService userService) {
        this.meetService = meetService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<MeetDTO>> getMeetsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(meetService.getMeetsByUser(userService.getUserById(userId)));
    }

    @GetMapping("/count:{userId}")
    public ResponseEntity<Integer> countMeetsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(meetService.countMeetsByUser(userService.getUserById(userId)));
    }
}
