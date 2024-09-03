package com.example.demo.controller;


import com.example.demo.constants.State;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.dto.user.UserAddDto;
import com.example.demo.service.dto.user.UserQueryDto;
import com.example.demo.service.dto.user.UserUpdateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "User Api Rest", description = "Endpoint para gestionar usuarios")
@RestController
@RequestMapping("")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "Agrega usuarios")
    @GetMapping(path = "")
    public ResponseEntity<List<UserQueryDto>> getUsers(@ApiParam(value = "filtro de estado")
                                        @RequestParam(required = false)  State state){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUsers(state));
    }
    @ApiOperation(value = "Agrega usuarios")
    @PostMapping(path = "")
    public ResponseEntity<Void> addUser(@ApiParam(value = "Datos de usuario")
                                                       @Valid @RequestBody UserAddDto userAddDto){
        userService.addUser(userAddDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza datos de un usuario")
    @PutMapping(path = "/{userId}")
    public ResponseEntity<Void> updateUser(@ApiParam(value = "Nuevos datos de usuario") @Valid @RequestBody UserUpdateDto userUpdateDto,
                                           @ApiParam(value = "id del usuario") @PathVariable long userId){
        userService.updateUser(userId, userUpdateDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @ApiOperation(value = "Elimina un usuario")
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@ApiParam(value = "id de usuario")
                                                       @PathVariable long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
