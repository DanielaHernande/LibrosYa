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

import com.riwi.LibrosYa.api.dto.request.BookRequest;
import com.riwi.LibrosYa.api.dto.response.BookResponse;
import com.riwi.LibrosYa.infrastructure.abstrac_services.IBookServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Tag(name = "Books")
@RequestMapping(path = "/books")
public class BookController {

    // Inyeccion de dependencia
    @Autowired
    private final IBookServices bookServices;

    // Obtener por Id
    @GetMapping(path = "/{book_id}")
    @Operation(
        summary = "Search for a book by id",
        description = "Obtain detailed information about a specific book."
    )
    public ResponseEntity<BookResponse> get(@PathVariable Long book_id) {

        return ResponseEntity.ok(this.bookServices.get(book_id));
    }

    // Obtener todo
    @GetMapping
    @Operation(
        summary = "Get book",
        description = "Get all book"
    )
    public ResponseEntity<Page<BookResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
        ) {
        
        return ResponseEntity.ok(this.bookServices.getAll(page - 1, size));
    }

    // Crear
    @PostMapping
    @Operation(
        summary = "Create book",
        description = "Create book with "
    )
    public ResponseEntity<BookResponse> create(@Validated @RequestBody BookRequest request) {

        return ResponseEntity.ok(this.bookServices.create(request));
    }

    // Actualizar
    @PutMapping(path = "/book_id")
    @Operation(
        summary = "Update a book", 
        description = "Update a book's information."
    )
    public ResponseEntity<BookResponse> update(
            @Validated @RequestBody BookRequest request,
            @PathVariable Long book_id) {

        return ResponseEntity.ok(this.bookServices.update(request, book_id));
    }

    // Eliminar
    @DeleteMapping(path = "/book_id")
    @Operation(
        summary = "Delete book",
        description = "Delete a book by id."
    )
    public ResponseEntity<Void> delete(@PathVariable Long user_id) {

        this.bookServices.delete(user_id);

        return  ResponseEntity.noContent().build();
    }
    
}
