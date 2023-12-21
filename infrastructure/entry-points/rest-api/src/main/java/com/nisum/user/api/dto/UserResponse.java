
package com.nisum.user.api.dto;

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
public class UserResponse {
    private String id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String name;
    private String email;
    private String password;
    private List<PhoneResponse> phones;
    private String lastLogin;
    private String token;
    private Boolean isActive;
}
