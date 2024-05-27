package com.developers.PinksiClub.service.implementation;

import com.developers.PinksiClub.dto.UserDTO;
import com.developers.PinksiClub.dtomapper.UserDTOMapper;
import com.developers.PinksiClub.model.User;
import com.developers.PinksiClub.repository.UserRepository;
import com.developers.PinksiClub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
