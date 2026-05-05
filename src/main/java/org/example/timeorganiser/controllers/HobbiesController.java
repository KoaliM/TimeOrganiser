package org.example.timeorganiser.controllers;

import dto.HobbiesDTO;
import org.example.timeorganiser.model.Hobbies;
import org.example.timeorganiser.services.HobbiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hobbies")
public class HobbiesController {
    private final HobbiesService hobbiesService;

    public  HobbiesController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @GetMapping
    public ResponseEntity<List<Hobbies>> getAllHobbies(){
        return ResponseEntity.ok(hobbiesService.getAllHobbies());
    }

    @PostMapping
    public ResponseEntity<HobbiesDTO> createHobbies(@RequestBody HobbiesDTO dto){
        return ResponseEntity.ok(hobbiesService.)
    }

    @GetMapping("{id}")
    public ResponseEntity<HobbiesDTO> getHobbiesById(@PathVariable Integer id){
        return ResponseEntity.ok(hobbiesService.getHobbiesById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<HobbiesDTO> updateHobby(@PathVariable Integer id, @RequestBody HobbiesDTO dto){
        return ResponseEntity.ok(hobbiesService.updateHobby(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HobbiesDTO> deleteHobby(@PathVariable Integer id){
        hobbiesService.deleteHobby(id);
        return ResponseEntity.noContent().build();
    }

}
