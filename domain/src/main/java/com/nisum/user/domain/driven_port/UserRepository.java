package com.nisum.user.domain.driven_port;

import com.nisum.user.domain.model.User;
import com.nisum.user.domain.value_object.Email;

import java.util.List;
import java.util.Optional;

public interface UserRepository  {
    List<User> findAll();
    Optional<User> findByEmail(Email email);
    User save(User user);
}
