package com.riwi.LibrosYa.infrastructure.abstrac_services;

import com.riwi.LibrosYa.api.dto.request.UserRequest;
import com.riwi.LibrosYa.api.dto.response.UserResponse;

public interface IUserServices extends CrudServices<UserRequest, UserResponse, Long>{
    
}
