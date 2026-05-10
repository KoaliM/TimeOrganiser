package org.example.timeorganiser.services;

import dto.MeetDTO;
import org.example.timeorganiser.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetService {
    public List<MeetDTO> getMeetsByUser(Users user) {
        return List.of();
    }

    public int countMeetsByUser(Users user) {
        return 0;
    }
}
