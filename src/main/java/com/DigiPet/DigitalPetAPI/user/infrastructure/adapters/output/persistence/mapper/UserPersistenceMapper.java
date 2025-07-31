package com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.mapper;

import com.DigiPet.DigitalPetAPI.user.domain.model.User;
import com.DigiPet.DigitalPetAPI.user.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    User toUser(UserEntity target);

    UserEntity toUserEntity(User target);

}
