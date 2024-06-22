package com.riwi.LibrosYa.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.riwi.LibrosYa.api.dto.request.UserRequest;
import com.riwi.LibrosYa.api.dto.response.UserResponse;
import com.riwi.LibrosYa.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    
    UserResponse toUserResponse(UserEntity userEntity);

    // Para ignorar
    @Mapping(target = "id", ignore = true)
    //@Mapping(target = "loans", ignore = true)
    //@Mapping(target = "reservations", ignore = true)

    @InheritInverseConfiguration
    UserEntity toUserEntity(UserRequest userRequest);

    List<UserResponse> UserListToResponseList(List<UserRequest> userRequest);
}
