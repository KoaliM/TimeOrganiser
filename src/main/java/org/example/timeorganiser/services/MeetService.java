package org.example.timeorganiser.services;

import dto.MeetDTO;
import jakarta.transaction.Transactional;
import org.example.timeorganiser.model.Users;
import org.example.timeorganiser.repository.MeetRepository;

import java.util.List;

public class MeetService {
    private final MeetRepository meetRepository;
    public MeetService(MeetRepository meetRepository) {
        this.meetRepository = meetRepository;
    }
    @Transactional
     public List<MeetDTO> getMeetsByUser(Users user){
        return meetRepository.findMeetsByUser(user);
     }
     public int countMeetsByUser(Users user){
        return meetRepository.countDesiredMeetingsByUser(user);
     }
}
