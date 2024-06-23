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

import com.riwi.LibrosYa.api.dto.request.ReservationRequest;
import com.riwi.LibrosYa.api.dto.response.ReservationResponse;
import com.riwi.LibrosYa.infrastructure.abstrac_services.IReservationServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Tag(name = "Books")
@RequestMapping(path = "/reservation")
public class ReservationController {
    
    // Inyeccion de dependencia
    @Autowired
    private final IReservationServices reservationServices;

    // Obtener por Id
    @GetMapping(path = "/{reservation_id}")
    @Operation(
        summary = "Search for a reservation by id",
        description = "Obtain detailed information about a specific reservation."
    )
    public ResponseEntity<ReservationResponse> get(@PathVariable Long reservation_id) {

        return ResponseEntity.ok(this.reservationServices.get(reservation_id));
    }

    // Obtener todo
    @GetMapping
    @Operation(
        summary = "Get reservation",
        description = "Get all reservation"
    )
    public ResponseEntity<Page<ReservationResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
        ) {
        
        return ResponseEntity.ok(this.reservationServices.getAll(page - 1, size));
    }

    // Crear
    @PostMapping
    @Operation(
        summary = "Create reservation",
        description = "Create reservation with information"
    )
    public ResponseEntity<ReservationResponse> create(@Validated @RequestBody ReservationRequest request) {

        return ResponseEntity.ok(this.reservationServices.create(request));
    }

    // Actualizar
    @PutMapping(path = "/reservation_id")
    @Operation(
        summary = "Update a reservation", 
        description = "Update a reservation's information."
    )
    public ResponseEntity<ReservationResponse> update(
            @Validated @RequestBody ReservationRequest request,
            @PathVariable Long reservation_id) {

        return ResponseEntity.ok(this.reservationServices.update(request, reservation_id));
    }

    // Eliminar
    @DeleteMapping(path = "/reservation_id")
    @Operation(
        summary = "Delete reservation",
        description = "Delete a reservation by id."
    )
    public ResponseEntity<Void> delete(@PathVariable Long reservation_id) {

        this.reservationServices.delete(reservation_id);

        return  ResponseEntity.noContent().build();
    }
}
