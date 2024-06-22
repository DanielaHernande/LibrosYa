package com.riwi.LibrosYa.infrastructure.abstrac_services;

import com.riwi.LibrosYa.api.dto.request.BookRequest;
import com.riwi.LibrosYa.api.dto.response.BookResponse;

public interface IBookServices extends CrudServices<BookRequest, BookResponse, Long>{
    
}
