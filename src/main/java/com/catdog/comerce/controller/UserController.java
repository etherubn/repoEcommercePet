package com.catdog.comerce.controller;

import com.catdog.comerce.dto.GenericResponse;
import com.catdog.comerce.dto.request.UserDto;
import com.catdog.comerce.dto.response.ResponseUserDto;
import com.catdog.comerce.service.IUserService;
import com.catdog.comerce.utils.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final MapperUtil mapperUtil;
    private final IUserService userService;


    @GetMapping
    public ResponseEntity<GenericResponse<ResponseUserDto>> findAllUsers(){
        List<ResponseUserDto> responseUserDtos = mapperUtil.mapList(userService.findAll(), ResponseUserDto.class);

        return new ResponseEntity<>(new GenericResponse<>(200,"success", responseUserDtos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ResponseUserDto>> findUser(@PathVariable Long id){
        ResponseUserDto responseUserDto = mapperUtil.map(userService.getById(id), ResponseUserDto.class);

        return new ResponseEntity<>(new GenericResponse<>(200,"success", Arrays.asList(responseUserDto)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<ResponseUserDto>> createUser(@RequestBody @Valid UserDto userDto){
        ResponseUserDto responseUserDto = mapperUtil.map(userService.createUser(userDto), ResponseUserDto.class);

        return new ResponseEntity<>(new GenericResponse<>(201,"success",Arrays.asList(responseUserDto)),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ResponseUserDto>> updateUser(@RequestBody @Valid UserDto userDto,@PathVariable Long id){
        ResponseUserDto responseUserDto = mapperUtil.map(userService.update(userDto,id), ResponseUserDto.class);
        return new ResponseEntity<>(new GenericResponse<ResponseUserDto>(200,"success",Arrays.asList(responseUserDto)),HttpStatus.OK);
    }







}
