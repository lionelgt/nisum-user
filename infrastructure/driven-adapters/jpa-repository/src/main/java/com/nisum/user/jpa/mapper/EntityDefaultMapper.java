package com.nisum.user.jpa.mapper;

import com.nisum.user.domain.value_object.Email;
import com.nisum.user.domain.value_object.Id;
import com.nisum.user.domain.value_object.Password;

import org.mapstruct.Named;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EntityDefaultMapper {
    private final Environment env;
    @Named("mapIdToUuid")
    public UUID mapIdToUuid(Id id) {
        return id.getValue();
    }
    
    @Named("mapUuidToId")
    public Id mapUuidToId(UUID uuid) {
        if (uuid != null) {
            return Id.of(uuid);
        }
        return null;
    }

    @Named("mapEmailToString")
    public String mapEmailToString(Email email) {
        return email.getValue();
    }
    
    @Named("mapStringToEmail")
    public Email mapStringToEmail(String email) {
        if (email != null) {
            return Email.of(email, env.getProperty("email.regex"));
        }
        return null;
    }

    @Named("mapPasswordToString")
    public String mapPasswordToString(Password password) {
        return password.getValue();
    }
    
    @Named("mapStringToPassword")
    public Password mapStringToPassword(String password) {
        if (password != null) {
            return Password.of(password, env.getProperty("password.regex"));
        }
        return null;
    }
}
