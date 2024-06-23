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

import com.riwi.LibrosYa.api.dto.request.LoanRequest;
import com.riwi.LibrosYa.api.dto.response.LoanResponse;
import com.riwi.LibrosYa.infrastructure.abstrac_services.ILoanServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Tag(name = "Loans")
@RequestMapping(path = "/loan")
public class LoanController {
    
    // Inyeccion de dependencia
    @Autowired
    private final ILoanServices loanServices;

    // Obtener por Id
    @GetMapping(path = "/{loan_id}")
    @Operation(
        summary = "Search for a loan by id",
        description = "Obtain detailed information about a specific loan."
    )
    public ResponseEntity<LoanResponse> get(@PathVariable Long loan_id) {

        return ResponseEntity.ok(this.loanServices.get(loan_id));
    }

    // Obtener todo
    @GetMapping
    @Operation(
        summary = "Get loan",
        description = "Get all loan"
    )
    public ResponseEntity<Page<LoanResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
        ) {
        
        return ResponseEntity.ok(this.loanServices.getAll(page - 1, size));
    }

    // Crear
    @PostMapping
    @Operation(
        summary = "Create lona",
        description = "Create loan with information "
    )
    public ResponseEntity<LoanResponse> create(@Validated @RequestBody LoanRequest request) {

        return ResponseEntity.ok(this.loanServices.create(request));
    }

    // Actualizar
    @PutMapping(path = "/loan_id")
    @Operation(
        summary = "Update a loan", 
        description = "Update a loan's information."
    )
    public ResponseEntity<LoanResponse> update(
            @Validated @RequestBody LoanRequest request,
            @PathVariable Long loan_id) {

        return ResponseEntity.ok(this.loanServices.update(request, loan_id));
    }

    // Eliminar
    @DeleteMapping(path = "/loan_id")
    @Operation(
        summary = "Delete loan",
        description = "Delete a loan by id."
    )
    public ResponseEntity<Void> delete(@PathVariable Long loan_id) {

        this.loanServices.delete(loan_id);

        return  ResponseEntity.noContent().build();
    }
}
