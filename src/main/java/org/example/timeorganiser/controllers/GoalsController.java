package org.example.timeorganiser.controllers;

import org.example.timeorganiser.integration.IntegrationData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/goals")
public class GoalsController {
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        return ResponseEntity.ok(IntegrationData.goals());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> goal) {
        IntegrationData.goals().add(goal);
        return ResponseEntity.ok(goal);
    }

    @PutMapping("/{title}/status")
    public ResponseEntity<Map<String, Object>> updateStatus(@PathVariable String title, @RequestBody Map<String, Object> body) {
        return updateByTitle(title, body);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> delete(@PathVariable String title) {
        IntegrationData.goals().removeIf(item -> title.equalsIgnoreCase(String.valueOf(item.get("title"))));
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Map<String, Object>> updateByTitle(String title, Map<String, Object> body) {
        return IntegrationData.goals().stream()
                .filter(item -> title.equalsIgnoreCase(String.valueOf(item.get("title"))))
                .findFirst()
                .map(item -> {
                    item.putAll(body);
                    return ResponseEntity.ok(item);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
