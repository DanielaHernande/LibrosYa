package com.riwi.LibrosYa.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.LibrosYa.domain.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
}