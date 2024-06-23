package com.riwi.LibrosYa.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.LibrosYa.api.dto.request.ReservationRequest;
import com.riwi.LibrosYa.api.dto.response.ReservationResponse;
import com.riwi.LibrosYa.domain.entities.Book;
import com.riwi.LibrosYa.domain.entities.Reservation;
import com.riwi.LibrosYa.domain.entities.UserEntity;
import com.riwi.LibrosYa.domain.repositories.BookRepository;
import com.riwi.LibrosYa.domain.repositories.ReservationRepository;
import com.riwi.LibrosYa.domain.repositories.UserRepository;
import com.riwi.LibrosYa.infrastructure.abstrac_services.IReservationServices;
//import com.riwi.LibrosYa.infrastructure.helpers.mappers.BookMapper;
import com.riwi.LibrosYa.infrastructure.helpers.mappers.ReservationMapper;
//import com.riwi.LibrosYa.infrastructure.helpers.mappers.UserMapper;
import com.riwi.LibrosYa.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationServices implements IReservationServices{
    
    // Inyeccion de dependencias
    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final ReservationMapper reservationMapper;

    // Inyeccion de dependencias user
    @Autowired
    private final UserRepository userRepository;

    // Inyeccion de dependencias book
    @Autowired
    private final BookRepository bookRepository;
    
    // Obtener solo uno 
    @Override
    public ReservationResponse get(Long id) {
        
        return this.reservationMapper.entityToReservationResponse(this.findId(id));
    }

    // OBtner todo
    @Override
    public Page<ReservationResponse> getAll(int page, int size) {

        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page - 1, size);

        return this.reservationRepository.findAll(pagination)
                .map(reservation -> this.reservationMapper.entityToReservationResponse(reservation));
    }

    // Crear
    @Override
    public ReservationResponse create(ReservationRequest request) {

        // Obtener user
        UserEntity userEntity = this.userRepository.findById(request.getUserId())
                        .orElseThrow(() -> new BadRequestException("No hay un usuario con ese id"));

        // Obtener book
        Book book = this.bookRepository.findById(request.getBookId())
                    .orElseThrow(() -> new BadRequestException("No hay un Libro con ese Id"));

        // Convertir el DTO a una entidad Assignment
        Reservation reservation = this.reservationMapper.reservationReqToEntity(request);

        // Asignar el user a la reservation
        reservation.setUserId(userEntity);

        // Asignar el libro a la reservation
        reservation.setBookId(book);

        // Guardar los libros y el user en el repositorio de reservation
        return this.reservationMapper.entityToReservationResponse(this.reservationRepository.save(reservation));
    }

    // Actualizar
    @Override
    public ReservationResponse update(ReservationRequest request, Long id) {

        // Obtener la reservation por su ID
        Reservation reservation = this.findId(id);

        // Obtener user
        UserEntity userEntity = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException("No hay un usuario con ese id"));

        // Obtener book
        Book book = this.bookRepository.findById(request.getBookId())
            .orElseThrow(() -> new BadRequestException("No hay un Libro con ese Id"));


        // Actualizar los campos de la tarea con los datos del DTO
        reservation.setBookId(book);
        //reservation.setReservationDate(request.getReservationDate());
        reservation.setStatus(request.isStatus());
        reservation.setUserId(userEntity);

        // Guardar los cambios en el repositorio de asignaciones
        return this.reservationMapper.entityToReservationResponse(this.reservationRepository.save(reservation));
    }

    // Eliminar
    @Override
    public void delete(Long id) {

        this.reservationRepository.delete(this.findId(id));
    }

    // Metodos privados
    // Buscar reservation por ID y lanzar excepción si no se encuentra
    private Reservation findId(Long id) {

        return this.reservationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay un libro con ese id"));
    }
    
}
