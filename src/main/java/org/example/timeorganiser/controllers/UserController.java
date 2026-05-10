package org.example.timeorganiser.controllers;

import org.example.timeorganiser.integration.IntegrationData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getUsers() {
        return ResponseEntity.ok(IntegrationData.users());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city) {
        String normalizedName = name == null ? "" : name.toLowerCase();
        String normalizedCity = city == null ? "" : city.toLowerCase();
        return ResponseEntity.ok(IntegrationData.users().stream()
                .filter(user -> normalizedName.isBlank()
                        || String.valueOf(user.get("name")).toLowerCase().contains(normalizedName)
                        || String.valueOf(user.get("username")).toLowerCase().contains(normalizedName))
                .filter(user -> normalizedCity.isBlank()
                        || String.valueOf(user.get("city")).toLowerCase().contains(normalizedCity))
                .toList());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable String userId, @RequestBody Map<String, Object> update) {
        return IntegrationData.users().stream()
                .filter(user -> userId.equals(String.valueOf(user.get("id"))))
                .findFirst()
                .map(user -> {
                    user.putAll(update);
                    return ResponseEntity.ok(user);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        IntegrationData.users().removeIf(user -> userId.equals(String.valueOf(user.get("id"))));
        return ResponseEntity.noContent().build();
    }
}
