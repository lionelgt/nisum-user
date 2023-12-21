package com.nisum.user.domain.use_case;

import com.nisum.user.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User create(User user);
}
