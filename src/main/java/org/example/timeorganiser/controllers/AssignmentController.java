package org.example.timeorganiser.controllers;

import dto.AssignmentsDTO;
import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.model.Users;
import org.example.timeorganiser.repository.AssignmentsRepository;
import org.example.timeorganiser.services.AssignmentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/assignments")
public class AssignmentController {
    private final AssignmentsService assignmentsService;
    private final AssignmentsRepository assignmentsRepository;

    public AssignmentController(AssignmentsService assignmentsService, AssignmentsRepository assignmentsRepository) {
        this.assignmentsService = assignmentsService;
        this.assignmentsRepository = assignmentsRepository;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        assignmentsService.deleteAssignments(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignments> update(@PathVariable Integer id, @RequestBody AssignmentsDTO assignments) {
        return ResponseEntity.ok(assignmentsService.updateAssignments(id, assignments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignments> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(assignmentsService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Assignments> create(@RequestBody AssignmentsDTO assignments) {
        return ResponseEntity.ok(assignmentsService.createAssignments(assignments));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Assignments>> getAll() {
        return ResponseEntity.ok(assignmentsService.findAllAssignments());
    }
}
