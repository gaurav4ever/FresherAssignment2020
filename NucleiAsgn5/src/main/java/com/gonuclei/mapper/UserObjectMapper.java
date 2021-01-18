package com.gonuclei.mapper;

import com.gonuclei.models.bo.UserBo;
import com.gonuclei.models.dto.SignupRequest;
import com.gonuclei.models.entities.UserEntity;

import org.mapstruct.Mapper;

/**
 * The interface User object mapper.
 */
@Mapper(componentModel = "spring")
public interface UserObjectMapper {

  /**
   * User request to user bo user bo.
   *
   * @param signupRequest the signup request
   * @return the user bo
   */
  UserBo userRequestToUserBo(SignupRequest signupRequest);

  /**
   * User bo to user entity user entity.
   *
   * @param userBo the user bo
   * @return the user entity
   */
  UserEntity userBoToUserEntity(UserBo userBo);
}
