package com.gonuclei.mapper;

import com.gonuclei.models.bo.EmailBo;
import com.gonuclei.models.bo.UserSubscriptionBo;
import com.gonuclei.models.dto.EmailDto;
import com.gonuclei.models.dto.UserSubscriptionResponse;
import com.gonuclei.models.entities.UserSubscriptionEntity;

import java.util.List;

import org.mapstruct.Mapper;

/**
 * The interface User subscription object mapper.
 */
@Mapper(componentModel = "spring")
public interface UserSubscriptionObjectMapper {

  /**
   * Entity to bo user subscription bo.
   *
   * @param userSubscriptionEntity the user subscription entity
   * @return the user subscription bo
   */
  UserSubscriptionBo entityToBo(UserSubscriptionEntity userSubscriptionEntity);

  /**
   * Bo to dto user subscription response.
   *
   * @param userSubscriptionBO the user subscription bo
   * @return the user subscription response
   */
  UserSubscriptionResponse boToDto(UserSubscriptionBo userSubscriptionBO);

  /**
   * Bo to entity user subscription entity.
   *
   * @param userSubscriptionBO the user subscription bo
   * @return the user subscription entity
   */
  UserSubscriptionEntity boToEntity(UserSubscriptionBo userSubscriptionBO);

  /**
   * Gets user subscription bo from entity list.
   *
   * @param userSubscriptionEntityList the user subscription entity list
   * @return the user subscription bo from entity list
   */
  List<UserSubscriptionBo> getUserSubscriptionBoFromEntityList(
    List<UserSubscriptionEntity> userSubscriptionEntityList);

  /**
   * Gets user subscription dtofrom bo list.
   *
   * @param userSubscriptionBoList the user subscription bo list
   * @return the user subscription dtofrom bo list
   */
  List<UserSubscriptionResponse> getUserSubscriptionDtofromBoList(
    List<UserSubscriptionBo> userSubscriptionBoList);


  /**
   * Gets email bo from dto.
   *
   * @param emailDto the email dto
   * @return the email bo from dto
   */
  EmailBo getEmailBoFromDto(EmailDto emailDto);

  /**
   * Gets user subscription entity from bo list.
   *
   * @param userSubscriptionBoList the user subscription bo list
   * @return the user subscription entity from bo list
   */
  List<UserSubscriptionEntity> getUserSubscriptionEntityFromBoList(List<UserSubscriptionBo> userSubscriptionBoList);
}
