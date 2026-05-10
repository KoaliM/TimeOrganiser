package org.example.timeorganiser.controllers;

import org.example.timeorganiser.integration.IntegrationData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    @GetMapping("/me/week")
    public ResponseEntity<List<Map<String, Object>>> getMyWeek() {
        return ResponseEntity.ok(List.of(
                Map.of(
                        "id", "busy-1",
                        "title", "Focus work",
                        "date", LocalDate.now().plusDays(1).toString(),
                        "start_time", "09:00",
                        "end_time", "11:00",
                        "type", "busy"
                )
        ));
    }

    @GetMapping("/google/status")
    public ResponseEntity<Map<String, Object>> getGoogleStatus() {
        return ResponseEntity.ok(Map.of("connected", false));
    }

    @GetMapping("/google/connect")
    public ResponseEntity<Map<String, Object>> connectGoogle() {
        return ResponseEntity.ok(Map.of("authorizationUrl", "https://calendar.google.com/"));
    }
}
