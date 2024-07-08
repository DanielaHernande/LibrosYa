package com.riwi.LibrosYa.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.LibrosYa.api.dto.request.LoanRequest;
import com.riwi.LibrosYa.api.dto.response.LoanResponse;
import com.riwi.LibrosYa.domain.entities.Book;
import com.riwi.LibrosYa.domain.entities.Loan;
import com.riwi.LibrosYa.domain.entities.UserEntity;
import com.riwi.LibrosYa.domain.repositories.BookRepository;
import com.riwi.LibrosYa.domain.repositories.LoanRepository;
import com.riwi.LibrosYa.domain.repositories.UserRepository;
import com.riwi.LibrosYa.infrastructure.abstrac_services.ILoanServices;
import com.riwi.LibrosYa.infrastructure.helpers.mappers.LoanMapper;
import com.riwi.LibrosYa.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanSercices implements ILoanServices{

    // Inyeccion de dependencias
    @Autowired
    private final LoanRepository loanRepository;

    // Inyeccion de dependencia Mapper
    @Autowired
    private final LoanMapper loanMapper;

    // Inyeccion de dependencias user
    @Autowired
    private final UserRepository userRepository;

    // Inyeccion de dependencias book
    @Autowired
    private final BookRepository bookRepository;

    // Obtener solo uno
    @Override
    public LoanResponse get(Long id) {

        // Buscar y devolver la loan por su ID
        return this.loanMapper.entityToLoanResponse(this.findId(id));
    }

    // Obtener todos
    @Override
    public Page<LoanResponse> getAll(int page, int size) {

        // Validar la página para asegurarse de que no sea negativa
        if (page < 0) page = 0;

        // Configurar la paginación para la consulta
        PageRequest pagination = PageRequest.of(page, size);

        // Obtener todas las loan con paginación y convertirlas a DTOs
        return this.loanRepository.findAll(pagination)
                .map(loan -> this.loanMapper.entityToLoanResponse(loan));
    }

    // Crear
    @Override
    public LoanResponse create(LoanRequest request) {

        // Obtener user
        UserEntity userEntity = this.userRepository.findById(request.getUserId())
                        .orElseThrow(() -> new BadRequestException("No hay un usuario con ese id"));

        // Obtener book
        Book book = this.bookRepository.findById(request.getBookId())
                    .orElseThrow(() -> new BadRequestException("No hay un Libro con ese Id"));

        // Convertir el DTO a una entidad Assignment
        Loan loan = this.loanMapper.loanReqToEntity(request);

        // Asignar el user a la reservation
        loan.setUserId(userEntity);

        // Asignar el libro a la reservation
        loan.setBookId(book);

        // Guardar los libros y el user en el repositorio de loan
        return this.loanMapper.entityToLoanResponse(this.loanRepository.save(loan));
    }

    // Actualizar
    @Override
    public LoanResponse update(LoanRequest request, Long id) {

        Loan loan = this.findId(id);

        // Obtener user
        UserEntity userEntity = this.userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException("No hay un usuario con ese id"));

        // Obtener book
        Book book = this.bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BadRequestException("No hay un Libro con ese Id"));

        // Actualizar los campos de la loan con los datos del DTO
        loan.setBookId(book);
        loan.setUserId(userEntity);
        loan.setStatus(request.isStatus());

        return this.loanMapper.entityToLoanResponse(this.loanRepository.save(loan));
    }

    // Eliminar
    @Override
    public void delete(Long id) {

        this.loanRepository.delete(this.findId(id));
    }

    // Metodos privados
    // Buscar loan por ID y lanzar excepción si no se encuentra
    private Loan findId(Long id) {

        return this.loanRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay un libro con ese id"));
    }
}
