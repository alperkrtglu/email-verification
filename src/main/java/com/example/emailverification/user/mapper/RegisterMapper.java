package com.example.emailverification.user.mapper;

import com.example.emailverification.user.User;
import com.example.emailverification.user.UserRegistrationRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterMapper {

    RegisterMapper INSTANCE = Mappers.getMapper(RegisterMapper.class);

    User toEntity(UserRegistrationRequestDTO dto);

}
