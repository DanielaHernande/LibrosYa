package com.riwi.LibrosYa.api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {
    
    @NotNull(message = "EL estatus es requerida")
    private boolean status;

    // User
    @NotNull(message = "EL id del usuario es requerido")
    @Positive(message = "El id del usuario debe ser un número positivo")
    private Long userId;

    // Book
    @NotNull(message = "EL id del libro es requerido")
    @Positive(message = "El id del libro debe ser un número positivo")
    private Long bookId;
}
