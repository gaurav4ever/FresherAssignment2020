package com.gonuclei.mapper;

import com.gonuclei.models.bo.SubscriptionBo;
import com.gonuclei.models.dto.SubscriptionResponse;
import com.gonuclei.models.entities.SubscriptionEntity;

import java.util.List;

import org.mapstruct.Mapper;

/**
 * The interface Subscription object mapper.
 */
@Mapper(componentModel = "spring")
public interface SubscriptionObjectMapper {

  /**
   * Dto to bo subscription bo.
   *
   * @param subscriptionResponse the subscription response
   * @return the subscription bo
   */
  SubscriptionBo dtoToBo(SubscriptionResponse subscriptionResponse);

  /**
   * Bo to entity subscription entity.
   *
   * @param subscriptionBo the subscription bo
   * @return the subscription entity
   */
  SubscriptionEntity boToEntity(SubscriptionBo subscriptionBo);

  /**
   * Entity to bo subscription bo.
   *
   * @param subscriptionEntity the subscription entity
   * @return the subscription bo
   */
  SubscriptionBo entityToBo(SubscriptionEntity subscriptionEntity);

  /**
   * Bo to dto subscription response.
   *
   * @param subscriptionBo the subscription bo
   * @return the subscription response
   */
  SubscriptionResponse boToDto(SubscriptionBo subscriptionBo);

  /**
   * Subscription bo from entity list list.
   *
   * @param subscriptionEntityList the subscription entity list
   * @return the list
   */
  List<SubscriptionBo> subscriptionBoFromEntityList
  (List<SubscriptionEntity> subscriptionEntityList);

  /**
   * Gets subscription response from bo list.
   *
   * @param subscriptionBoList the subscription bo list
   * @return the subscription response from bo list
   */
  List<SubscriptionResponse> getSubscriptionResponseFromBoList
  (List<SubscriptionBo> subscriptionBoList);
}
