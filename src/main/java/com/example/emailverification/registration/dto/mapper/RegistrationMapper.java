package com.example.emailverification.registration.dto.mapper;

import com.example.emailverification.registration.dto.RegistrationRequestDTO;
import com.example.emailverification.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationMapper {

    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);

    User toEntity(RegistrationRequestDTO dto);
}
