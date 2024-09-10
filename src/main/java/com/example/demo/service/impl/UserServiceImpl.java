package com.example.demo.service.impl;

import com.example.demo.constants.State;
import com.example.demo.model.entity.User;
import com.example.demo.model.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.dto.user.UserAddDto;
import com.example.demo.service.dto.user.UserQueryDto;
import com.example.demo.service.dto.user.UserUpdateDto;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserQueryDto> getUsers() {
        List<User> users;
        users = userRepository.findAll();
        List<UserQueryDto> userQueryDtos = new ArrayList<>();
        for (User s: users) {
            UserQueryDto userQueryDto = new UserQueryDto();
            BeanUtils.copyProperties(s, userQueryDto);
            userQueryDtos.add(userQueryDto);
        }
        return userQueryDtos;
    }

    @Override
    public void addUser(UserAddDto userAddDto) {
        User user = new User();
        BeanUtils.copyProperties(userAddDto, user);
        userRepository.save(user);
    }

    @Override
    public void updateUser(long userId, UserUpdateDto userUpdateDto) {
        User user = userRepository.getById(userId);
        BeanUtils.copyProperties(userUpdateDto,user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long userId) {

    }
}
