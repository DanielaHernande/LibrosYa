package com.riwi.LibrosYa.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationToUserBasicResponse {
    
    private Long id;

    private LocalDate reservationDate;

    private boolean status;
}
