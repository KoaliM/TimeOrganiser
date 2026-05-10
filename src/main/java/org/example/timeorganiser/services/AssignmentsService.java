package org.example.timeorganiser.services;

import dto.AssignmentDeadlineDTO;
import dto.AssignmentsDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.repository.AssignmentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentsService {
    private final AssignmentsRepository assignmentsRepository;
    private final ModelMapper modelMapper;

    public AssignmentsService(AssignmentsRepository assignmentsRepository, ModelMapper modelMapper) {
        this.assignmentsRepository = assignmentsRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Assignments createAssignments(@RequestBody AssignmentsDTO assignments) {
        return assignmentsRepository.save(modelMapper.map(assignments, Assignments.class));
    }
    public Assignments getById(Integer id){
        if(!assignmentsRepository.existsById(id)){
            throw new EntityNotFoundException("Assignment not found");
        }
        return assignmentsRepository.getById(id);
    }
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
        return List.of();
    }

    public List<String> findAfterDate(Date date){
        return List.of();
    }

    public List<AssignmentDeadlineDTO> findUrgentAssignments(){
        return List.of();
    }

    public Assignments updateAssignments(Integer id, AssignmentsDTO dto){
        Assignments assignment = assignmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asssignment not found"));
        modelMapper.map(dto, assignment);

        return assignmentsRepository.save(assignment);
    }

}
