package com.riwi.LibrosYa.api.dto.request;

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
public class ReservationRequest {

    @NotBlank(message = "El estatus es requerido")
    private boolean status;

    // User
    @NotNull(message = "EL id del usuario es requerido")
    @Size(

        min = 1,
        message = "El id usuario debe de tener minimo un numero"
    )
    private Long userId;

    // Libro
    @NotNull(message = "EL id del libro es requerido")
    @Size(

        min = 1,
        message = "El id del libro debe de tener minimo un numero"
    )
    private Long bookId;
}
