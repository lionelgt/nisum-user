package com.nisum.user.jpa.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity extends BaseAuditEntity {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean isActive;
    @OneToMany(mappedBy = "userId")
    private List<PhoneEntity> phones;
}
