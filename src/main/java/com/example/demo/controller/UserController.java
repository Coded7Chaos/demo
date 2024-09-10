package com.example.demo.controller;


import com.example.demo.Valid;
import com.example.demo.constants.State;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.dto.user.UserAddDto;
import com.example.demo.service.dto.user.UserQueryDto;
import com.example.demo.service.dto.user.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Api Rest", description = "Endpoint para gestionar usuarios")
@RestController
@RequestMapping("")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Lista usuarios")
    @GetMapping(path = "")
    public ResponseEntity<List<UserQueryDto>> getUsers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUsers());
    }
    @Operation(summary = "Agrega usuarios")
    @PostMapping(path = "")
    public ResponseEntity<Void> addUser(@Parameter(description = "Datos de usuario") @RequestBody UserAddDto userAddDto){
        userService.addUser(userAddDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza datos de un usuario")
    @PutMapping(path = "/{userId}")
    public ResponseEntity<Void> updateUser(@Parameter(description = "Nuevos datos de usuario") @Valid @RequestBody UserUpdateDto userUpdateDto,
                                           @Parameter(description = "id del usuario") @PathVariable long userId){
        userService.updateUser(userId, userUpdateDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @Operation(summary = "Elimina un usuario")
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@Parameter(description = "id de usuario")
                                                       @PathVariable long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
