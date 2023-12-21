package com.nisum.user.api.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private List<PhoneRequest> phones;
}
