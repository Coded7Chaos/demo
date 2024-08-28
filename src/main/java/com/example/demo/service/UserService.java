package com.example.demo.service;

import com.example.demo.constants.State;
import com.example.demo.service.dto.user.UserAddDto;
import com.example.demo.service.dto.user.UserQueryDto;
import com.example.demo.service.dto.user.UserUpdateDto;

import java.util.List;

public interface UserService {
    List<UserQueryDto> getUsers(State state);
    void addUser(UserAddDto userAddDto);
    void updateUser(long userId, UserUpdateDto userUpdateDto);
    void deleteUser(long userId);
}
