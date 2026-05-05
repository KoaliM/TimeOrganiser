package org.example.timeorganiser.controllers;

import dto.MeetDTO;
import org.example.timeorganiser.services.MeetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meet")
public class MeetController {
    private final MeetService meetService;

    public MeetController(MeetService meetService){
        this.meetService = meetService;
    }

    @GetMapping("/{userId}")
    public List<MeetDTO> getMeetsByUserId(@PathVariable Integer userId){
        return meetService.getMeetsByUser()
    }
}
