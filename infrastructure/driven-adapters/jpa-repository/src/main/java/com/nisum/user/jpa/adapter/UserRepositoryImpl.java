package com.nisum.user.jpa.adapter;

import com.nisum.user.domain.driven_port.UserRepository;
import com.nisum.user.domain.model.User;
import com.nisum.user.domain.value_object.Email;
import com.nisum.user.jpa.entity.UserEntity;
import com.nisum.user.jpa.mapper.UserEntityMapper;
import com.nisum.user.jpa.repository.UserRepositoryJpa;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserRepositoryJpa userRepositoryJpa;
    private final UserEntityMapper userEntityMapper;

    public List<User> findAll(){
        return userRepositoryJpa.findAll().stream()
                                .map(userEntityMapper::map)
                                .toList();
    }
    
    public Optional<User> findByEmail(Email email){
        return userRepositoryJpa.findByEmail(email.getValue()).map(userEntityMapper::map);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity =  userRepositoryJpa.save(userEntityMapper.map(user));
        return userEntityMapper.map(userEntity);
    }
}
