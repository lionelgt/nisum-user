package com.nisum.user.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phones")
public class PhoneEntity extends BaseAuditEntity {
    @Id
    private UUID id;
    private UUID userId;
    private String number;
    private String cityCode;
    private String countryCode;
}
