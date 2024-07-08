package com.riwi.LibrosYa.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookBasicResponse {
    
    private Long id;

    private String title;

    private String author;

    private int publicationYear;

    private String gerent;

    private String isbn;
}
