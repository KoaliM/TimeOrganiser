package org.example.timeorganiser.controllers;

import org.example.timeorganiser.integration.IntegrationData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/friends")
public class FriendsController {
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getFriendships() {
        return ResponseEntity.ok(IntegrationData.friendships());
    }

    @GetMapping("/users")
    public ResponseEntity<List<Map<String, Object>>> getFriendUsers() {
        return ResponseEntity.ok(IntegrationData.users().stream()
                .filter(user -> "friend".equals(user.get("status")))
                .toList());
    }

    @PostMapping("/requests")
    public ResponseEntity<Map<String, Object>> createFriendRequest(@RequestBody Map<String, Object> request) {
        Map<String, Object> friendship = IntegrationData.friendship(
                String.valueOf(request.getOrDefault("user_id", "1")),
                String.valueOf(request.get("partner_id")),
                "pending"
        );
        IntegrationData.friendships().add(friendship);
        return ResponseEntity.ok(friendship);
    }

    @DeleteMapping("/requests/{friendId}")
    public ResponseEntity<Void> deleteFriendRequest(@PathVariable String friendId) {
        IntegrationData.friendships().removeIf(friendship -> friendId.equals(String.valueOf(friendship.get("friend_id"))));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{friendId}/availability")
    public ResponseEntity<List<Map<String, Object>>> getFriendAvailability(
            @PathVariable String friendId,
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end) {
        return IntegrationData.users().stream()
                .filter(user -> friendId.equals(String.valueOf(user.get("id"))))
                .findFirst()
                .map(user -> ResponseEntity.ok((List<Map<String, Object>>) user.get("availabilityPeriods")))
                .orElse(ResponseEntity.ok(List.of()));
    }
}
