package com.newsletter.controllers;

import com.newsletter.bos.NewsletterBo;
import com.newsletter.constants.Constants;
import com.newsletter.dtos.NewsletterDto;
import com.newsletter.mappers.NewsletterObjectMapper;
import com.newsletter.services.impl.NewsletterServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Newsletter controller.
 */
@RestController
public class NewsletterController {

  @Autowired
  private NewsletterServiceImpl service;

  @Autowired
  private NewsletterObjectMapper newsletterObjectMapper;

  /**
   * Gets all newsletters.
   *
   * @return the all newsletters
   */
  @GetMapping(path = "/getAllNewslettersDetails")
  public List<NewsletterDto> getAllNewsletters() {
    return newsletterObjectMapper
            .getSubscriptionResponseFromBoList(service.getAllNewslettersDetails());
  }

  /**
   * Add newsletter.
   *
   * @param dto the dto
   */
  @PostMapping(path = "/addNewsletter")
  public void addNewsletter(@RequestBody NewsletterDto dto) {
    service.saveNewsletter(newsletterObjectMapper.dtoToBo(dto));
  }

  /**
   * Edit newsletter.
   *
   * @param dto the dto
   */
  @PutMapping(path = "/editNewsletter")
  public void editNewsletter(@RequestBody NewsletterDto dto) {
    service.editNewsletter(newsletterObjectMapper.dtoToBo(dto));
  }

  /**
   * Delete newsletter response entity.
   *
   * @param id the id
   * @return the response entity
   */
  @DeleteMapping(path = "/deleteNewsletter/{id}")
  public ResponseEntity<String> deleteNewsletter(@PathVariable int id) {
    boolean response = service.deleteNewsletter(id);
    if (response) {
      return new ResponseEntity<>("Successfull deleted", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Id does not exist. Please re-check it.",
          HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Add content response entity.
   *
   * @param newsletterBo the newsletter bo
   * @param id           the id
   * @return the response entity
   */
  @PutMapping(path = "/addContent")
  public ResponseEntity<String> addContent(@RequestBody NewsletterBo newsletterBo,
      @RequestParam("id") int id) {
    boolean response = service.addContent(id, newsletterBo);
    if (response) {
      return new ResponseEntity<>(Constants.SUCCESS_ADDED, HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Type does not exist. Please re-check it.",
          HttpStatus.BAD_REQUEST);
    }
  }


}
