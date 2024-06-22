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
public class LoanResponse {

    private Long id;

    private LocalDate loanDate;

    private LocalDate returnDate;

    private boolean status;

    // User
    private Long userId;

    // Book
    private Long bookId;
}