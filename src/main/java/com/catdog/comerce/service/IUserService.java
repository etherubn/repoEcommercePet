package com.catdog.comerce.service;

import com.catdog.comerce.dto.request.UserDto;
import com.catdog.comerce.dto.response.ResponseUserDto;

public interface IUserService extends ICrudService<UserDto,Long>{
    ResponseUserDto createUser(UserDto userDto);
}
