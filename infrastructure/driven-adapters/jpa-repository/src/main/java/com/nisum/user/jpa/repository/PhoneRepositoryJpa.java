package com.nisum.user.jpa.repository;

import com.nisum.user.jpa.entity.PhoneEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneRepositoryJpa extends JpaRepository<PhoneEntity, UUID> {
}
