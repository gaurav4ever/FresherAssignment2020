package com.newsletter.mappers;

import com.newsletter.bos.NewsletterBo;
import com.newsletter.dtos.NewsletterDto;
import com.newsletter.entities.NewsletterEntity;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * The interface Newsletter object mapper.
 */
@Mapper(componentModel = "spring")
public interface NewsletterObjectMapper {

  /**
   * Dto to bo newsletter bo.
   *
   * @param newsletterDto the newsletter dto
   * @return the newsletter bo
   */
  NewsletterBo dtoToBo(NewsletterDto newsletterDto);

  /**
   * Entity to bo newsletter bo.
   *
   * @param newsletterEntity the newsletter entity
   * @return the newsletter bo
   */
  NewsletterBo entityToBo(NewsletterEntity newsletterEntity);

  /**
   * Bo to entity newsletter entity.
   *
   * @param newsletterBo the newsletter bo
   * @return the newsletter entity
   */
  NewsletterEntity boToEntity(NewsletterBo newsletterBo);

  /**
   * Bo to dto newsletter dto.
   *
   * @param newsletterBo the newsletter bo
   * @return the newsletter dto
   */
  NewsletterDto boToDto(NewsletterBo newsletterBo);

  /**
   * Subscription bo from entity list list.
   *
   * @param newsletterEntityList the newsletter entity list
   * @return the list
   */
  List<NewsletterBo> subscriptionBoFromEntityList(List<NewsletterEntity> newsletterEntityList);

  /**
   * Gets subscription response from bo list.
   *
   * @param newsletterBoList the newsletter bo list
   * @return the subscription response from bo list
   */
  List<NewsletterDto> getSubscriptionResponseFromBoList(List<NewsletterBo> newsletterBoList);
}
