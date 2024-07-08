package com.riwi.LibrosYa.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.LibrosYa.api.dto.request.UserRequest;
import com.riwi.LibrosYa.api.dto.response.UserResponse;
import com.riwi.LibrosYa.domain.entities.UserEntity;
import com.riwi.LibrosYa.domain.repositories.UserRepository;
import com.riwi.LibrosYa.infrastructure.abstrac_services.IUserServices;
import com.riwi.LibrosYa.infrastructure.helpers.mappers.UserMapper;
import com.riwi.LibrosYa.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServices implements IUserServices{

    // Inyeccion de dependencias
    @Autowired
    private final UserRepository userRepository;

    // Inyeccion de dependencia Mapper
    @Autowired
    private final UserMapper userMapper;

    // Obtener solo uno
    @Override
    public UserResponse get(Long id) {

        return this.userMapper.toUserResponse(this.findId(id));
    }

    // Obtener todo
    @Override
    public Page<UserResponse> getAll(int page, int size) {

        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination)
                .map(user -> this.userMapper.toUserResponse(user)); 
    }

    // Crear
    @Override
    public UserResponse create(UserRequest request) {

        UserEntity userEntity = this.userMapper.toUserEntity(request);

        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));
    }

    // Actualizar
    @Override
    public UserResponse update(UserRequest request, Long id) {

        UserEntity userEntity = this.findId(id);

        userEntity = this.userMapper.toUserEntity(request);
        userEntity.setId(id);

        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));
    }

    // Eliminar
    @Override
    public void delete(Long id) {

        this.userRepository.delete(this.findId(id));
    }

    // Metodos privados
    // Buscar usuario por ID y lanzar excepción si no se encuentra
    private UserEntity findId(Long id) {

        return this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay usuarios con ese id"));
    }
}