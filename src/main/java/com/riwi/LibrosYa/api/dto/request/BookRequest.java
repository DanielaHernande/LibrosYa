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
public class BookRequest {

    @NotBlank(message = "Title is requerido")
    @Size(

        min = 2,
        max = 100,
        message = "El titulo debe tener entre 2 y 100 caracteres" 
    )
    private String title;

    @NotBlank(message = "The author is requerido")
    @Size(

        min = 2,
        max = 100,
        message = "El userName debe tener entre 2 y 100 caracteres" 
    )
    private String author;

    @NotNull(message = "El año de publicacion es requerido")
    private int publicationYear;

    @NotBlank(message = "The gerent is requerido")
    @Size(

        min = 2,
        max = 50,
        message = "El gerent debe tener entre 2 y 50 caracteres" 
    )
    private String gerent;

    @NotBlank(message = "The Isbn is requerido")
    @Size(

        min = 2,
        max = 20,
        message = "El Isbn debe tener entre 2 y 20 caracteres" 
    )
    private String isbn;
}
