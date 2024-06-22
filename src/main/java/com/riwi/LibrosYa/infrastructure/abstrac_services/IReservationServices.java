package com.riwi.LibrosYa.infrastructure.abstrac_services;

import com.riwi.LibrosYa.api.dto.request.ReservationRequest;
import com.riwi.LibrosYa.api.dto.response.ReservationResponse;

public interface IReservationServices extends CrudServices<ReservationRequest, ReservationResponse, Long>{
    
}
