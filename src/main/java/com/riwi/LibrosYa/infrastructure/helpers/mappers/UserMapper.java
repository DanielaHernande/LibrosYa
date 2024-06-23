package com.riwi.LibrosYa.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.LibrosYa.api.dto.request.UserRequest;
import com.riwi.LibrosYa.api.dto.response.UserResponse;
import com.riwi.LibrosYa.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    
    UserResponse toUserResponse(UserEntity userEntity);

    // Para ignorar


    UserEntity toUserEntity(UserRequest userRequest);

    List<UserResponse> UserListToResponseList(List<UserRequest> userRequest);
}
