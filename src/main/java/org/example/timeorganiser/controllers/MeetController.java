package org.example.timeorganiser.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/meet")
public class MeetController {
    @GetMapping("/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getMeetsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/count:{userId}")
    public ResponseEntity<Integer> countMeetsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(0);
    }
}
