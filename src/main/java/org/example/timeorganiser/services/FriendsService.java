package org.example.timeorganiser.services;

import dto.FriendsDTO;
import jakarta.transaction.Transactional;
import org.example.timeorganiser.model.Assignments;
import org.example.timeorganiser.model.Friends;
import org.example.timeorganiser.repository.FriendsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FriendsService {
    private final FriendsRepository friendsRepository;
    private final ModelMapper modelMapper;

    public FriendsService(FriendsRepository friendsRepository, ModelMapper modelMapper) {
        this.friendsRepository = friendsRepository;
        this.modelMapper = modelMapper;
    }
    @Transactional
    public Friends addFriends(FriendsDTO friends) {
        return friendsRepository.save(modelMapper.map(friends, Friends.class));
    }
}
