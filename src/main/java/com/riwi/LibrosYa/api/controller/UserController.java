package com.riwi.LibrosYa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.LibrosYa.api.dto.request.UserRequest;
import com.riwi.LibrosYa.api.dto.response.UserResponse;
import com.riwi.LibrosYa.infrastructure.abstrac_services.IUserServices;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private final IUserServices userServices;

    // Obtener por Id
    @GetMapping(path = "/{user_id}")
    @Operation(
        summary = "Search for a user by id",
        description = "Obtain detailed information about a specific user."
    )
    public ResponseEntity<UserResponse> get(@PathVariable Long user_id) {

        return ResponseEntity.ok(this.userServices.get(user_id));
    }

    // Obtener todo
    @GetMapping
    @Operation(
        summary = "Get users",
        description = "Get all users"
    )
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
        ) {
        
        return ResponseEntity.ok(this.userServices.getAll(page - 1, size));
    }

    // Crear
    @PostMapping
    @Operation(
        summary = "Create users",
        description = "Create users with different roles"
    )
    public ResponseEntity<UserResponse> create(@Validated @RequestBody UserRequest request) {

        return ResponseEntity.ok(this.userServices.create(request));
    }

    // Actualizar
    @PutMapping(path = "/user_id")
    @Operation(
        summary = "Update a user", 
        description = "Update a user's information."
    )
    public ResponseEntity<UserResponse> update(
            @Validated @RequestBody UserRequest request,
            @PathVariable Long user_id) {

        return ResponseEntity.ok(this.userServices.update(request, user_id));
    }

    // Eliminar
    @DeleteMapping(path = "/user_id")
    @Operation(
        summary = "Delete User",
        description = "Delete a user by id."
    )
    public ResponseEntity<Void> delete(@PathVariable Long user_id) {

        this.userServices.delete(user_id);

        return  ResponseEntity.noContent().build();
    }

}
