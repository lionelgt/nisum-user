package com.nisum.user.domain.use_case;

import com.nisum.user.domain.driven_port.JwtTokenPort;
import com.nisum.user.domain.driven_port.PhoneRepository;
import com.nisum.user.domain.driven_port.UserRepository;
import com.nisum.user.domain.exception.UserException;
import com.nisum.user.domain.model.Phone;
import com.nisum.user.domain.model.User;
import com.nisum.user.domain.value_object.Email;
import com.nisum.user.domain.value_object.Id;
import com.nisum.user.domain.value_object.Password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    private UserRepository userRepository = mock(UserRepository.class);
    private PhoneRepository phoneRepository = mock(PhoneRepository.class);
    private JwtTokenPort jwtTokenPort = mock(JwtTokenPort.class);

    private UserService itemService = new UserServiceImpl(userRepository, phoneRepository, jwtTokenPort);

    @Test
    void create() {
        User user =  buildUserMock();
        given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.empty());
        given(jwtTokenPort.createToken(any())).willReturn("token");
        when(userRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());
        when(phoneRepository.saveAll(any())).then(AdditionalAnswers.returnsFirstArg());

        User userSaved = itemService.create(user);
        assertThat(userSaved.getId()).isNotNull();
    }

    @Test
    void createUserExist() {
        User user =  buildUserMock();
        given(userRepository.findByEmail(user.getEmail())).willReturn(Optional.of(user));
       
        Assertions.assertThrows(UserException.class, () -> {
            itemService.create(user);
        });
    }
    
    private User buildUserMock(){
        return User.builder()
                .id(Id.make())
                .name("uan Rodriguez")
                .password(Password.of("Hunter123455@", "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}:;<>,.?/~_+=|]).{8,32}$"))
                .email(Email.of("juan@rodriguez.org", "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"))
                .phones(Arrays.asList(buildPhoneMock())).build();
    }

    private Phone buildPhoneMock(){
        return Phone.builder()
                   .number("123456789")
                   .cityCode("1")
                   .countryCode("57")
                   .build();
    }
}
