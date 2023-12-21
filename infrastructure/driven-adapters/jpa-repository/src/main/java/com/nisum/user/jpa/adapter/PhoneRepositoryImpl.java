package com.nisum.user.jpa.adapter;

import com.nisum.user.domain.driven_port.PhoneRepository;
import com.nisum.user.domain.model.Phone;
import com.nisum.user.jpa.entity.PhoneEntity;
import com.nisum.user.jpa.mapper.UserEntityMapper;
import com.nisum.user.jpa.repository.PhoneRepositoryJpa;

import org.springframework.stereotype.Repository;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PhoneRepositoryImpl implements PhoneRepository {
    private final PhoneRepositoryJpa phoneRepositoryJpa;
    private final UserEntityMapper userEntityMapper;

    @Override
    public List<Phone> saveAll(List<Phone> phones) {
        List<PhoneEntity> phoneEntitiesToSave = phones.stream().map(userEntityMapper::map).toList();
        List<PhoneEntity> phoneEntities =  phoneRepositoryJpa.saveAll(phoneEntitiesToSave);
        return phoneEntities.stream().map(userEntityMapper::map).toList();
    }
}
