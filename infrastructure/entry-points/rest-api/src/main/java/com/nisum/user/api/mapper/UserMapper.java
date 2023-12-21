package com.nisum.user.api.mapper;

import com.nisum.user.api.dto.PhoneResponse;
import com.nisum.user.api.dto.UserRequest;
import com.nisum.user.api.dto.UserResponse;
import com.nisum.user.domain.model.Phone;
import com.nisum.user.domain.model.User;

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
        uses = {DefaultMapper.class}
)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "email", target = "email", qualifiedByName = {"mapStringToEmail"}),
            @Mapping(source = "password", target = "password", qualifiedByName = {"mapStringToPassword"})
    })
    User map(UserRequest userRequest);

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = {"mapIdToUuid"}),
            @Mapping(source = "email", target = "email", qualifiedByName = {"mapEmailToString"}),
            @Mapping(source = "password", target = "password", qualifiedByName = {"mapPasswordToString"})
    })
    UserResponse map(User user);

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = {"mapIdToUuid"})
    })
    PhoneResponse map(Phone phone);
    
    
}
