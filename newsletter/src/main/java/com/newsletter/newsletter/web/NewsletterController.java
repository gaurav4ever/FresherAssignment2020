package com.newsletter.newsletter.web;

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

import com.newsletter.newsletter.model.Newletterdetails;
import com.newsletter.newsletter.model.NewletterdetailsDTO;
import com.newsletter.newsletter.service.NewsletterService;

@RestController
public class NewsletterController {
	@Autowired NewsletterService service;
	
	@GetMapping(path="/getAllNewslettersDetails")
	public List<Newletterdetails> getAllNewsletters() {
		return service.getAllNewslettersDetails();
	}
	
	@PostMapping(path="/addNewsletter")
	public void addNewsletter(@RequestBody NewletterdetailsDTO dto ) {
		service.saveNewsletter(dto);
	}
	
	@PutMapping(path="/editNewsletter")
	public void editNewsletter(@RequestBody NewletterdetailsDTO dto) {
		service.editNewsletter(dto);
	}
	//id is appended in the url
	@DeleteMapping(path="/deleteNewsletter/{id}")
	public ResponseEntity<String> deleteNewsletter(@PathVariable int id) {
		int response = service.deleteNewsletter(id);
		if(response ==1) {
			return new ResponseEntity<>("Successfull deleted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Id does not exist. Please re-check it.",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(path="/addContent")
	public ResponseEntity<String> addContent(@RequestBody NewletterdetailsDTO dto,@RequestParam("id") int id){
		int response = service.addContent(id,dto);
		if(response ==1) {
			return new ResponseEntity<>("Successfull added",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Type does not exist. Please re-check it.",HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
