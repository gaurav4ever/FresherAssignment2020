package com.newsletter.newsletter.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.internet.MimeMessage;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


import com.newsletter.newsletter.DTO.SubscriptionRepository;
import com.newsletter.newsletter.model.Subscription;
import com.newsletter.newsletter.model.SubscriptionDto;


@Component
public class SubscriptionService {
	@Autowired SubscriptionRepository repo;
	@Autowired private JavaMailSender sender;
	@Autowired NewsletterService newsletterService;
	public List<Subscription> getAllSubscriptions(){
		return repo.findAll();
	}

	public int buyASubscription(SubscriptionDto s) {
		Subscription subscription = new Subscription();
		System.out.println(s.toString());
		subscription.setSubscriptionid(s.getSubscriptionid());
		subscription.setDailyweekly(s.getDailyweekly());
		subscription.setDateOfSubscription(s.getDateOfSubscription());
		subscription.setEmail(s.getEmail());
		subscription.setEndDateOfSubscription(s.getDateOfSubscription());
		subscription.setId(s.getId());
		subscription.setIsCanceled(s.getIsCanceled());
		subscription.setIsRenewed(s.getIsRenewed());
		subscription.setIsSubscribed(s.getIsSubscribed());
		subscription.setNewsLetterType(s.getNewsLetterType());
		System.out.println(subscription);
		try {
			repo.save(subscription);
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
	
	public void sendContentThroughEmail() throws Exception {
		List<Subscription> subscriptions = repo.findAll();
		List<String> emails = new ArrayList<String>();
		
		//get current day
		Calendar calendar = Calendar.getInstance();
		int d = calendar.get(Calendar.DAY_OF_WEEK);
		String days[] = {"mon","tues","wed","thus","fri","sat","sun"}; 
		String day = days[d-2];
		System.out.println(d+" "+day);
		for(Subscription s : subscriptions) {
			if(s.getDailyweekly().equalsIgnoreCase("DAILY") || s.getDailyweekly().equalsIgnoreCase(day)) {
				
				System.out.println(s.getEmail());
				String content = newsletterService.getContent(s.getId());
				sendEmail(s.getEmail(),content,s.getNewsLetterType());
			}
		}
		
		
	}
	
	private void sendEmail(String email,String content,String subject) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setTo(email);
        helper.setText(content);
        helper.setSubject(subject);
         
        sender.send(message);
    }
	
	@Value("${kafka.bootstrap.servers}")
	private String kafkaBootstrapServers;
	
	public Properties getProperties() {
		 Properties props = new Properties();
		 props.put("bootstrap.servers", "localhost:9092");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 return props;
	}
	

	KafkaProducer<String,String> producer = new KafkaProducer<>(getProperties());
	//private static final Logger logger = Logger.getLogger(NewsletterApplication.class);
	private static void sendKafkaMessage(String payload,KafkaProducer<String,String> producer,String topic) {
		producer.send(new ProducerRecord<>(topic,payload));
	}
	private void checkProducerService() {
		for (int index = 0; index < 10; index++) {
		    sendKafkaMessage("The index is now: " + index, producer, "email");

		}
	}
}
