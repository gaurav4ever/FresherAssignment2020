package com.newsletter.newsletter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsletter.newsletter.DTO.NewsletterRepository;
import com.newsletter.newsletter.model.Newletterdetails;
import com.newsletter.newsletter.model.NewletterdetailsDTO;

@Component
public class NewsletterService {
	@Autowired NewsletterRepository newsletterrepo;
	public List<Newletterdetails> getAllNewslettersDetails(){
		return newsletterrepo.findAll();
	}
	
	public void saveNewsletter(NewletterdetailsDTO dto) {
		Newletterdetails newsletter=new Newletterdetails();
		newsletter.setName(dto.getName());
		//here content is regularly updated by the admin
		newsletter.setContent(dto.getContent());
		newsletter.setDailyprice(dto.getDailyprice());
		newsletter.setWeeklyprice(dto.getWeeklyprice());
		newsletterrepo.save(newsletter);
	}
	
	public void editNewsletter(NewletterdetailsDTO dto) {
		Newletterdetails newsletter=null;
		List<Newletterdetails> l = newsletterrepo.findAll();
		for(Newletterdetails e:l) {
			if(e.getId() == dto.getId()) {
				newsletter = e;
				break;
			}
		}
		if(newsletter == null) {
			saveNewsletter(dto);
		}
		else {
			newsletter.setContent(dto.getContent());
			newsletter.setName(dto.getName());
			newsletter.setDailyprice(dto.getDailyprice());
			newsletter.setWeeklyprice(dto.getWeeklyprice());
			newsletterrepo.save(newsletter);
		}
	}
	
	public int deleteNewsletter(int id) {
		List<Newletterdetails> l = newsletterrepo.findAll();
		for(Newletterdetails e:l) {
			if(e.getId() == id) {
				newsletterrepo.deleteById(id);
				return 1;
			}
		}
		//0 if id not found
		return 0;
	}
	
	public int addContent(int id,NewletterdetailsDTO dto) {
		try {
			Optional<Newletterdetails> n = newsletterrepo.findById(id);
			Newletterdetails newl=n.get();
			newl.setContent(dto.getContent());
			newsletterrepo.save(newl);
			return 1;
		}
		catch(Exception e) {
			return 0;
		}
		
	}
}
