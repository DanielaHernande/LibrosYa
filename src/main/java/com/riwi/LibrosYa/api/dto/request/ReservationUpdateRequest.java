package com.riwi.LibrosYa.api.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ReservationUpdateRequest {
    
    @NotBlank(message = "El estatus es requerido")
    private boolean status;
    
    @FutureOrPresent
    private LocalDate reservationDate;

    // User
    @NotNull(message = "EL id del usuario es requerido")
    @Positive(message = "El id del usuario debe ser un número positivo")
    private Long userId;

    // Libro
    @NotNull(message = "EL id del libro es requerido")
    @Positive(message = "El id del usuario debe ser un número positivo")
    private Long bookId;
}
