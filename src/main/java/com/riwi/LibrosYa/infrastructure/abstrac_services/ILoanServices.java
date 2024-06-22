package com.riwi.LibrosYa.infrastructure.abstrac_services;

import com.riwi.LibrosYa.api.dto.request.LoanRequest;
import com.riwi.LibrosYa.api.dto.response.LoanResponse;

public interface ILoanServices extends CrudServices<LoanRequest, LoanResponse, Long>{
    
}