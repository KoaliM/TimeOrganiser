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
@RequestMapping("/api/hobbies")
public class HobbiesController {
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllHobbies() {
        return ResponseEntity.ok(IntegrationData.hobbies());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createHobbies(@RequestBody Map<String, Object> hobby) {
        IntegrationData.hobbies().add(hobby);
        return ResponseEntity.ok(hobby);
    }

    @PutMapping("/{title}/status")
    public ResponseEntity<Map<String, Object>> updateStatus(@PathVariable String title, @RequestBody Map<String, Object> body) {
        return updateByTitle(title, body);
    }

    @PutMapping("/{title}")
    public ResponseEntity<Map<String, Object>> updateHobby(@PathVariable String title, @RequestBody Map<String, Object> body) {
        return updateByTitle(title, body);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteHobby(@PathVariable String title) {
        IntegrationData.hobbies().removeIf(item -> title.equalsIgnoreCase(String.valueOf(item.get("title"))));
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<Map<String, Object>> updateByTitle(String title, Map<String, Object> body) {
        return IntegrationData.hobbies().stream()
                .filter(item -> title.equalsIgnoreCase(String.valueOf(item.get("title"))))
                .findFirst()
                .map(item -> {
                    item.putAll(body);
                    return ResponseEntity.ok(item);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
