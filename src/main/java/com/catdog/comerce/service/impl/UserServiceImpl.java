package com.catdog.comerce.service.impl;

import com.catdog.comerce.dto.request.UserDto;

import com.catdog.comerce.dto.response.ResponseUserDto;
import com.catdog.comerce.entity.Role;
import com.catdog.comerce.entity.User;
import com.catdog.comerce.enums.RoleType;
import com.catdog.comerce.exception.AlreadyExistsException;
import com.catdog.comerce.exception.NotFoundException;
import com.catdog.comerce.repository.RoleRepo;
import com.catdog.comerce.repository.UserRepo;
import com.catdog.comerce.repository.RepoGeneric;
import com.catdog.comerce.service.IUserService;
import com.catdog.comerce.utils.MapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl extends CrudServiceImpl<UserDto, User,Long> implements IUserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;

    public UserServiceImpl(MapperUtil mapperUtil, UserRepo userRepo, RoleRepo roleRepo) {
        super(mapperUtil);
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    protected RepoGeneric<User, Long> getRepo() {
        return userRepo;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserDto> getDtoClass() {
        return UserDto.class;
    }

    @Override
    protected void setId(User entity, Long aLong) {
        entity.setIdUser(aLong);
    }

    @Transactional
    public ResponseUserDto createUser(UserDto userDto) {
        if (userRepo.findByDni(userDto.getDni()).isPresent()){
            throw new AlreadyExistsException(getEntityClass().getSimpleName(),"dni",userDto.getDni());
        }

        if (userRepo.findByEmail(userDto.getEmail()).isPresent()){
            throw new AlreadyExistsException(getEntityClass().getSimpleName(),"email",userDto.getEmail());
        }

        if (userRepo.findByUsername(userDto.getUsername()).isPresent()){
            throw new AlreadyExistsException(getEntityClass().getSimpleName(),"username",userDto.getUsername());
        }

        Role role = roleRepo.findByType(RoleType.USER).orElseThrow(()->new NotFoundException("role", roleRepo.findIdByRole(RoleType.USER)));

        User user = mapperUtil.map(userDto, User.class);
        user.setRole(role);

        ResponseUserDto responseUserDto = mapperUtil.map(userRepo.save(user), ResponseUserDto.class);


        return responseUserDto;
    }

    @Override
    public UserDto update(UserDto userDto, Long aLong) {
        Optional<User> optionalUser = userRepo.findByDni(userDto.getDni());

        if (optionalUser.isPresent() && !optionalUser.get().getIdUser().equals(aLong)){
            throw new AlreadyExistsException(getEntityClass().getSimpleName(),"dni",userDto.getDni());
        }

        optionalUser = userRepo.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent() && !optionalUser.get().getIdUser().equals(aLong)){
            throw new AlreadyExistsException(getEntityClass().getSimpleName(),"email",userDto.getEmail());
        }

        optionalUser = userRepo.findByUsername(userDto.getUsername());

        if (optionalUser.isPresent() && !optionalUser.get().getIdUser().equals(aLong)){
            throw new AlreadyExistsException(getEntityClass().getSimpleName(),"username",userDto.getUsername());
        }

        User user = mapperUtil.map(userDto, User.class);
        user.setIdUser(aLong);

        User savedUser = userRepo.save(user);
        return mapperUtil.map(savedUser, UserDto.class);
    }
}
