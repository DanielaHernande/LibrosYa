package com.riwi.LibrosYa.api.dto.response;

import java.util.List;

import com.riwi.LibrosYa.utils.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    
    private Long id;

    private String userName;

    private String password;

    private String email;

    private String fullName;

    private Role role;

    private List<LoanToUserBasicResponse> loans;

    private List<ReservationToUserBasicResponse> reservations;
}
