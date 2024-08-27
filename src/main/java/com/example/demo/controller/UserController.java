package com.example.demo.controller;


import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "User Api Rest", description = "Endpoint para gestionar usuarios")
@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @ApiOperation(value = "Lista usuarios")
    @GetMapping(path = "")
    public ResponseEntity<List<UsersQueryDto>> getUsers(@ApiParam)
        //falta crear el UsersQueryDto
}
