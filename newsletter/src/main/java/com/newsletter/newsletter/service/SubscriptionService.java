package com.newsletter.newsletter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newsletter.newsletter.DTO.SubscriptionRepository;
import com.newsletter.newsletter.model.Subscription;

@Component
public class SubscriptionService {
	@Autowired SubscriptionRepository repo;
	
	public List<Subscription> getAllSubscriptions(){
		return repo.findAll();
	}

	public int buyASubscription(Subscription s) {
		try {
			repo.save(s);
			return 1;
		}
		catch(Exception e) {
			return 0;	
		}
		
	}
	
	public int cancelSubscription(long id) {
		Optional<Subscription> s = repo.findById(id);
		if(s==null) {
			return 0;
		}
		else {
			Subscription ss = s.get();
			ss.setIsCanceled((byte) 1);
			ss.setIsSubscribed((byte) 0);
			ss.setEndDateOfSubscription(new Date());
			repo.save(ss);
			return 1;
		}
	}
	
	public int renewSubscription(long id,Date date,String dailyweekly) {
		Optional<Subscription> s = repo.findById(id);
		if(s==null) {
			return 0;
		}
		else {
			Subscription ss = s.get();
			ss.setIsCanceled((byte) 0);
			ss.setIsSubscribed((byte) 1);
			ss.setIsRenewed((byte) 1);
			ss.setDateOfSubscription(new Date());
			ss.setEndDateOfSubscription(date);
			if(dailyweekly!=null) {
				ss.setDailyweekly(dailyweekly);
			}
			repo.save(ss);
			return 1;
		}
	}
	//filter on the basis of movie type
	public List<Subscription> getSubscriptionOfType(String s){
		List<Subscription> l = repo.findAll();
		
		switch(s)
		{
		case "isCanceled" : 
			return l.stream().filter(sub-> sub.getIsCanceled()==1)
								.collect(Collectors.toList());
		case "isSubscribed" : 
			return l.stream().filter(sub->sub.getIsSubscribed()==1)
					.collect(Collectors.toList());
		case "isRenewed" : 
			return l.stream().filter(sub->sub.getIsRenewed()==1)
					.collect(Collectors.toList());

		}
		
		//based on the type of news letter
		return l.stream().filter(sub->sub.getNewsLetterType().equals(s))
				.collect(Collectors.toList());
	}
	
	//sort on the basis of email,dateOfSubscription,endDateOfSubscription
	public List<Subscription> sortSubscriptions(String type,String sortOrder){
		List<Subscription> l = repo.findAll();
		switch(type) {
		case "email":
			if(sortOrder.equals("asc")) {
				Collections.sort(l,(Subscription o1, Subscription o2)->{
					return o1.getEmail().compareToIgnoreCase(o2.getEmail());
				});
			}
			else {
				Collections.sort(l,(Subscription o1, Subscription o2)->{
					return -(o1.getEmail().compareToIgnoreCase(o2.getEmail()));
				});
			}
			break;
		case "dateOfSubscription":
			if(sortOrder.equals("asc")) {
				Collections.sort(l,(Subscription o1, Subscription o2)->{
					return o1.getDateOfSubscription().compareTo(o2.getDateOfSubscription());
				});
			}
			else {
				Collections.sort(l,(Subscription o1, Subscription o2)->{
					return -o1.getDateOfSubscription().compareTo(o2.getDateOfSubscription());
				});
			}
			break;
		case "endDateOfSubscription":
			if(sortOrder.equals("asc")) {
				Collections.sort(l,(Subscription o1, Subscription o2)->{
					return o1.getEndDateOfSubscription().compareTo(o2.getEndDateOfSubscription());
				});
			}
			else {
				Collections.sort(l,(Subscription o1, Subscription o2)->{
					return -o1.getEndDateOfSubscription().compareTo(o2.getEndDateOfSubscription());
				});
			}
			break;
		}
		
		return l;
	}

	public List<Subscription> searchSubscriptionsBetweenDates(Date startDate,Date endDate){
		List<Subscription> l = repo.findAll();
		for(Subscription s:l) {
			System.out.println(s.getDateOfSubscription().compareTo(startDate));
		}
		return l;
	}
	
	
}
