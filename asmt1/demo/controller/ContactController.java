package asmt1.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asmt1.demo.converter.ContactConverter;
import asmt1.demo.dto.AddressReq;
import asmt1.demo.dto.ContactDto;
import asmt1.demo.entity.Contact;
import asmt1.demo.repository.ContactRepo;

//@restcontroller is used for restful services 
@RestController
//@RequestMapping is used for creating baseurl for controller will be used
@RequestMapping("/contact")
public class ContactController {

	//@Autowired will search the object of class
	@Autowired
	private ContactRepo ctrepo;
	@Autowired
	private ContactConverter converter;
	
	
	//@Requestbody is used to map/bind methods with pojo pr value to return value to the web
	//@postmapping is used to add data to database from web
	@PostMapping("/add")
	public Contact newcontact(@RequestBody AddressReq req) {
		 return ctrepo.save(req.getContact());
	}
	
	//@getmapping is used to get the details/records from database on web page
	@GetMapping("/contactlist")
	public List<Contact> getcontactlist(){
		return ctrepo.findAll(Sort.by(Sort.Direction.ASC, "firstName","lastName"));
	}
	@GetMapping("/contactdto")
	public List<ContactDto> getcontactlistdto(){
		List<Contact> findAll=ctrepo.findAll();
		return converter.entitytodto(findAll);
	}
	@GetMapping("/contactlist/{id}")
	public ResponseEntity<Contact> get(@PathVariable Long id) {
	    try {
	       Contact contact = ctrepo.getOne(id);
	        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
	    }      
	}
	@GetMapping("/contactdto/{id}")
	public ContactDto getbyid(@PathVariable Long id) {
	       Contact orElse=ctrepo.findById(id).orElse(null);
	       return converter.entitytodto(orElse);
	}
	
	@GetMapping("/orderlist")
	public List<Contact> getcontactlistbyorder(){
		return ctrepo.findAllByOrderByIdDesc();
	}
	
	@PostMapping("/save")
	public ContactDto savedto(@RequestBody ContactDto dto) {
		Contact contact=converter.dtotoentity(dto);
		contact=ctrepo.save(contact);
		return converter.entitytodto(contact);
	}
	
	
	//@deletemapping is used to delete the records/details from database by web page
	@DeleteMapping("/delete/{id}")
	public String deletebyid(@PathVariable long id){
		if (ctrepo.findById(id)==null) {
			return "Id not found.....Please enter correct id";
		}
		 ctrepo.deleteById(id);
		 return "Successfully deleted "+id;
	}
	
	//@putmapping is used to change/update the records/details in database by web page
	@PutMapping("/edit")
	public Contact editcontactbyid(@RequestBody AddressReq req ){
		return ctrepo.save(req.getContact());
	}
}