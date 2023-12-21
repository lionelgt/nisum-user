package com.nisum.user.domain.use_case;

import com.nisum.user.domain.annotation.UseCase;
import com.nisum.user.domain.driven_port.PhoneRepository;
import com.nisum.user.domain.driven_port.UserRepository;
import com.nisum.user.domain.exception.UserException;
import com.nisum.user.domain.model.Phone;
import com.nisum.user.domain.model.User;
import com.nisum.user.domain.value_object.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User create(User user) {
       Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent())
            throw new UserException("email.exist", 409);


        user.setId(Id.make());
        user.setLastLogin(LocalDateTime.now());
        user.setIsActive(true);
        user.setToken("token");
        User userSaved =  userRepository.save(user);
        
        user.getPhones().stream().forEach(p -> {
            p.setId(Id.make());
            p.setUserId(userSaved.getId());
        });
        List<Phone> phones = phoneRepository.saveAll(user.getPhones());
        userSaved.setPhones(phones);
        
        return userSaved;
    }
}
