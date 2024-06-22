package com.riwi.LibrosYa.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.LibrosYa.api.dto.request.LoanRequest;
import com.riwi.LibrosYa.api.dto.response.LoanResponse;
import com.riwi.LibrosYa.domain.entities.Loan;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {
    
    LoanResponse toLoanResponse(Loan loan);

    //Loan toLoanEntity(LoanRequest loanRequest);

    List<LoanResponse> UserListToResponseList(List<LoanRequest> loanRequests);
}
