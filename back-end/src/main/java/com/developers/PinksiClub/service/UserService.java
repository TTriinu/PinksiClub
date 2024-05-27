package com.developers.PinksiClub.service;

import com.developers.PinksiClub.dto.UserDTO;
import com.developers.PinksiClub.model.User;

public interface UserService {
    UserDTO createUser(User user);
}
