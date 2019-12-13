package com.newsletter.newsletter.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsletter.newsletter.model.Newletterdetails;

public interface NewsletterRepository extends JpaRepository<Newletterdetails,Integer> {

}
