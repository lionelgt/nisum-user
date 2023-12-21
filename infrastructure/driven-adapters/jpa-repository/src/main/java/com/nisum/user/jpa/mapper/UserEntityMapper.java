package com.nisum.user.jpa.mapper;

import com.nisum.user.domain.model.Phone;
import com.nisum.user.domain.model.User;
import com.nisum.user.jpa.entity.PhoneEntity;
import com.nisum.user.jpa.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {EntityDefaultMapper.class}
)
public interface UserEntityMapper {

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = {"mapIdToUuid"}),
            @Mapping(source = "email", target = "email", qualifiedByName = {"mapEmailToString"}),
            @Mapping(source = "password", target = "password", qualifiedByName = {"mapPasswordToString"}),
    })
    UserEntity map(User user);

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = {"mapIdToUuid"}),
            @Mapping(source = "userId", target = "userId", qualifiedByName = {"mapIdToUuid"})
    })
    PhoneEntity map(Phone phone);

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = {"mapUuidToId"}),
            @Mapping(source = "email", target = "email", qualifiedByName = {"mapStringToEmail"}),
            @Mapping(source = "password", target = "password", qualifiedByName = {"mapStringToPassword"}),
    })
    User map(UserEntity userEntity);

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = {"mapUuidToId"}),
            @Mapping(source = "userId", target = "userId", qualifiedByName = {"mapUuidToId"})
    })
    Phone map(PhoneEntity phoneEntity);
}
