package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.assignment.repository.AddressRepo;
import com.example.assignment.repository.ContactRepo;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner{

	@Autowired
	private ContactRepo ctrepo;
	
	@Autowired
	private AddressRepo addrepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Status status=Status.Active;
		Contact contact1=new Contact("Alex", "Rick", 464621520,"alex@gmail.com" ,status);
		Contact contact2 =new Contact("Tom", "Ran", 653448890, "tom@gmail.com",status);
		
		
		Address add1=new Address("A/204", "Mansarovar bldg", "Mumbai", "Maharashtra", "India",86798996l);
		Address add2=new Address("A/703", "Mansarovar bldg", "Mumbai", "Maharashtra", "India",8679899655l);

		contact1.getAddress().add(add1);
		contact1.getAddress().add(add2);
		
		add1.getContact().add(contact1);
		add2.getContact().add(contact1);
		
		this.ctrepo.save(contact1);
		this.ctrepo.save(contact2);	
	
	}

}
