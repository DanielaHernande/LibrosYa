package com.riwi.LibrosYa.api.dto.request;

import com.riwi.LibrosYa.utils.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    
    @NotBlank(message = "Username is requerido")
    @Size(

        min = 2,
        max = 50,
        message = "El userName debe tener entre 2 y 50 caracteres" 
    )
    private String userName;

    @NotBlank(message = "Password is requerido")
    @Size(

        min = 3,
        max = 100,
        message = "La contraseña debe tener entre 3 y 100 caracteres"
    )
    private String password;

    @Email
    @NotBlank(message = "EL email is requerido")
    private String email;

    @NotBlank(message = "EL nombre completo es requerido")
    @Size(

        min = 2,
        max = 100,
        message = "EL nombre completo debe tener entre 3 y 100 caracteres"
    )
    private String fullName;

    @NotNull(message = "El ROL es requeriso")
    private Role role;
}
