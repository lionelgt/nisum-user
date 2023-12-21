package com.nisum.user.domain.driven_port;

import com.nisum.user.domain.model.Phone;

import java.util.List;

public interface PhoneRepository {
    List<Phone> saveAll(List<Phone> phones);
}
