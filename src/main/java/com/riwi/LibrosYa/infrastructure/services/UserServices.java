package com.riwi.LibrosYa.infrastructure.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.LibrosYa.api.dto.request.UserRequest;
import com.riwi.LibrosYa.api.dto.response.UserResponse;
import com.riwi.LibrosYa.domain.entities.UserEntity;
import com.riwi.LibrosYa.domain.repositories.UserRepository;
import com.riwi.LibrosYa.infrastructure.abstrac_services.IUserServices;
import com.riwi.LibrosYa.infrastructure.helpers.mappers.UserMapper;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    // Eliminar
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Metodos privados
    // Buscar usuario por ID y lanzar excepción si no se encuentra
    private UserEntity findId(Long id) {

        return this.userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay usuarios con ese id"));
    }
}
