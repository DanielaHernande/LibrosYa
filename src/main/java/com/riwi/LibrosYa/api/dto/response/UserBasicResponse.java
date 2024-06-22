package com.riwi.LibrosYa.api.dto.response;

import com.riwi.LibrosYa.utils.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBasicResponse {
    
    private Long id;

    private String userName;

    private String password;

    private String email;

    private String fullName;

    private Role role;
}
