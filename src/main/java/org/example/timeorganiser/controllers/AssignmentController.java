package org.example.timeorganiser.controllers;

import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.services.AssignmentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/assignments")
public class AssignmentController {
    private final AssignmentsService assignmentsService;

    public AssignmentController(AssignmentsService assignmentsService) {
        this.assignmentsService = assignmentsService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        assignmentsService.deleteAssignments(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignments> update(@PathVariable Integer id, @RequestBody Assignments assignments) {}
}
