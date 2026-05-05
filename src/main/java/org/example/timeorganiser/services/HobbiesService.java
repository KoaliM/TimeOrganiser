package org.example.timeorganiser.services;

import dto.AssignmentsDTO;
import dto.HobbiesDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.model.Hobbies;
import org.example.timeorganiser.repository.HobbiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HobbiesService {
    private final HobbiesRepository hobbiesRepository;
    private final ModelMapper modelMapper;

    public HobbiesService(HobbiesRepository hobbiesRepository, ModelMapper modelMapper){
        this.hobbiesRepository = hobbiesRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<Hobbies> getAllHobbies(){
        hobbiesRepository.findAll();
    }
    public Hobbies createHobbies(@RequestBody HobbiesDTO hobbies) {
        return hobbiesRepository.save(modelMapper.map(hobbies, Hobbies.class));
    }

    public HobbiesDTO getHobbiesById(@PathVariable Integer id){
        if(!hobbiesRepository.existsById(id)){
            throw new EntityNotFoundException("Hobby not found");
        }
        return hobbiesRepository.getById(id);
    }

    public Hobbies updateHobbies(Integer id, HobbiesDTO dto){
        Hobbies hobby = hobbiesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hobby not found"));
        modelMapper.map(dto, hobby);

        return hobbiesRepository.save(hobby);
    }

    public void deleteHobby(Integer id){
        if(!hobbiesRepository.existsById(id)){
            throw new EntityNotFoundException("Hobby with id " + id + " does not exist");
        }
        hobbiesRepository.deleteById(id);
    }
}
