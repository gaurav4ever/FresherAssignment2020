package com.newsletter.mappers;

import com.newsletter.bos.SubscriptionBo;
import com.newsletter.dtos.SubscriptionDto;
import com.newsletter.entities.SubscriptionEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionObjectMapper {

  SubscriptionBo dtoToBo(SubscriptionDto subscriptionDto);

  SubscriptionBo entityToBo(SubscriptionEntity subscriptionEntity);

  SubscriptionEntity boToEntity(SubscriptionBo subscriptionBo);

  SubscriptionDto boToDto(SubscriptionBo subscriptionBo);

  List<SubscriptionBo> subscriptionBoFromEntityList(
          List<SubscriptionEntity> subscriptionEntityList);

  List<SubscriptionDto> getSubscriptionResponseFromBoList(List<SubscriptionBo> subscriptionBoList);
}
