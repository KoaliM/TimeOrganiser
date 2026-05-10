package org.example.timeorganiser.integration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class IntegrationData {
    private static final List<Map<String, Object>> users = new ArrayList<>();
    private static final List<Map<String, Object>> friendships = new ArrayList<>();
    private static final List<Map<String, Object>> assignments = new ArrayList<>();
    private static final List<Map<String, Object>> tasks = new ArrayList<>();
    private static final List<Map<String, Object>> goals = new ArrayList<>();
    private static final List<Map<String, Object>> hobbies = new ArrayList<>();

    static {
        users.add(user("1", "Alex Morgan", "alex", "Sofia", 24, "Europe/Sofia", "friend"));
        users.add(user("2", "Mira Petrova", "mira", "Plovdiv", 22, "Europe/Sofia", "not-befriended"));
        friendships.add(friendship("1", "2", "pending"));
        assignments.add(item("Launch plan", "1", "todo", "high", LocalDate.now().plusDays(5).toString()));
        tasks.add(task("Prepare timeline", "1", "Launch plan", "todo", "medium", LocalDate.now().plusDays(2).toString()));
        goals.add(item("Finish semester", "1", "todo", "high", null));
        hobbies.add(hobby("Running", "medium", "3"));
    }

    private IntegrationData() {
    }

    public static List<Map<String, Object>> users() {
        return users;
    }

    public static List<Map<String, Object>> friendships() {
        return friendships;
    }

    public static List<Map<String, Object>> assignments() {
        return assignments;
    }

    public static List<Map<String, Object>> tasks() {
        return tasks;
    }

    public static List<Map<String, Object>> goals() {
        return goals;
    }

    public static List<Map<String, Object>> hobbies() {
        return hobbies;
    }

    public static Map<String, Object> createUser(String username, String email) {
        Map<String, Object> existing = findUserByUsername(username);
        if (existing != null) {
            return profile(existing);
        }

        Map<String, Object> user = user(UUID.randomUUID().toString(), username, username, "Sofia", 18, "Europe/Sofia", "not-befriended");
        user.put("email", email);
        users.add(user);
        return profile(user);
    }

    public static Map<String, Object> findOrCreateUser(String username) {
        Map<String, Object> existing = findUserByUsername(username);
        if (existing != null) {
            return profile(existing);
        }
        return createUser(username, username + "@example.com");
    }

    public static Map<String, Object> profile(Map<String, Object> user) {
        return Map.of(
                "id", String.valueOf(user.get("id")),
                "userName", String.valueOf(user.get("username")),
                "role", "User"
        );
    }

    public static Map<String, Object> item(String title, String userId, String status, String priority, String dueDate) {
        Map<String, Object> item = new LinkedHashMap<>();
        item.put("title", title);
        item.put("user_id", userId);
        item.put("status", status);
        item.put("priority", priority);
        if (dueDate != null) {
            item.put("due_date", dueDate);
        }
        return item;
    }

    public static Map<String, Object> task(String title, String userId, String assignmentId, String status, String priority, String dueDate) {
        Map<String, Object> task = item(title, userId, status, priority, dueDate);
        task.put("assignment_id", assignmentId);
        return task;
    }

    public static Map<String, Object> hobby(String title, String priority, String occurrencePerWeek) {
        Map<String, Object> hobby = new LinkedHashMap<>();
        hobby.put("title", title);
        hobby.put("priority", priority);
        hobby.put("occurence_per_week", occurrencePerWeek);
        return hobby;
    }

    public static Map<String, Object> availability(String date, String startTime, String endTime) {
        return Map.of("date", date, "start_time", startTime, "end_time", endTime);
    }

    public static Map<String, Object> friendship(String userId, String friendId, String status) {
        Map<String, Object> friendship = new LinkedHashMap<>();
        friendship.put("user_id", userId);
        friendship.put("friend_id", friendId);
        friendship.put("status", status);
        friendship.put("friendship_time", null);
        return friendship;
    }

    private static Map<String, Object> findUserByUsername(String username) {
        return users.stream()
                .filter(user -> username.equalsIgnoreCase(String.valueOf(user.get("username"))))
                .findFirst()
                .orElse(null);
    }

    private static Map<String, Object> user(String id, String name, String username, String city, int age, String timezone, String status) {
        Map<String, Object> user = new LinkedHashMap<>();
        user.put("id", id);
        user.put("name", name);
        user.put("username", username);
        user.put("age", age);
        user.put("city", city);
        user.put("timezone", timezone);
        user.put("availability", "Weekdays after 18:00");
        user.put("status", status);
        user.put("bio", "Time organiser user");
        user.put("hobbies", List.of("Study", "Fitness"));
        user.put("initials", initials(name));
        user.put("availabilityPeriods", List.of(
                availability(LocalDate.now().plusDays(1).toString(), "18:00", "20:00"),
                availability(LocalDate.now().plusDays(3).toString(), "17:00", "19:00")
        ));
        return user;
    }

    private static String initials(String name) {
        String[] parts = name.trim().split("\\s+");
        if (parts.length == 1) {
            return parts[0].substring(0, 1).toUpperCase();
        }
        return (parts[0].substring(0, 1) + parts[1].substring(0, 1)).toUpperCase();
    }
}
