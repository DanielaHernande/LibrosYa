package com.riwi.LibrosYa.infrastructure.helpers.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import com.riwi.LibrosYa.api.dto.request.ReservationRequest;
import com.riwi.LibrosYa.api.dto.response.ReservationResponse;
import com.riwi.LibrosYa.domain.entities.Book;
import com.riwi.LibrosYa.domain.entities.Reservation;
import com.riwi.LibrosYa.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

    @Mapping(target = "userId", source = "userId", qualifiedByName = "mapUserIdToUserEntity")
    @Mapping(target = "bookId", source = "bookId", qualifiedByName = "mapBookIdToBook")
    @Mapping(target = "id", ignore = true) // Ignorar id si es generado automáticamente
    
    Reservation reservationReqToEntity(ReservationRequest reservationReq);

    @Named("mapUserIdToUserEntity")
    default UserEntity mapUserIdToUserEntity(Long userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        return userEntity;
    }

    @Named("mapBookIdToBook")
    default Book mapBookIdToBook(Long bookId) {
        Book book = new Book();
        book.setId(bookId);
        return book;
    }

    ReservationResponse entityToReservationResponse(Reservation reservation);

    List<ReservationResponse> toListReservationResp(List<Reservation> reservations);
}
