package org.example.timeorganiser.services;

import dto.AssignmentDeadlineDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.repository.AssignmentsRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentsService {
    private final AssignmentsRepository assignmentsRepository;

    public AssignmentsService(AssignmentsRepository assignmentsRepository) {
        this.assignmentsRepository = assignmentsRepository;
    }

    @Transactional
    public Assignments save(Assignments assignments) {
        return assignmentsRepository.save(assignments);
    }

    public void deleteAssignments(Integer id){
        if(!assignmentsRepository.existsById(id)){
            throw new EntityNotFoundException("Assignment with id " + id + " does not exist");
        }
        assignmentsRepository.deleteById(id);
    }
    public List<Assignments> findAllAssignments(){
        return assignmentsRepository.findAll();
    }

    public List<AssignmentDeadlineDTO> findLeftTime(){
        return assignmentsRepository.findLeftTime();
    }

    public List<String> findAfterDate(Date date){
        return assignmentsRepository.findAfterDate(date);
    }

    public List<AssignmentDeadlineDTO> findUrgentAssignments(){
        return assignmentsRepository.findUrgentAssignments();
    }

}
