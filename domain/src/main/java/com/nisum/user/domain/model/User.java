package com.nisum.user.domain.model;

import com.nisum.user.domain.value_object.Email;
import com.nisum.user.domain.value_object.Id;
import com.nisum.user.domain.value_object.Password;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Id id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String name;
    private Email email;
    private Password password;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
    private List<Phone> phones;
}
