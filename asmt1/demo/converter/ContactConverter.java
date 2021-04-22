package asmt1.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import asmt1.demo.dto.ContactDto;
import asmt1.demo.entity.Contact;

@Component
public class ContactConverter {

	public ContactDto entitytodto(Contact contact) {
		ContactDto dto=new ContactDto();
		dto.setId(contact.getId());
		dto.setFirstName(contact.getFirstName());
		dto.setContactNo(contact.getContactNo());
		dto.setStatus(contact.getStatus());
		dto.setMailId(contact.getMailId());
		dto.setAddress(contact.getAddress());
		return dto;
	}
	
	public List<ContactDto> entitytodto(List<Contact> contact) {
	
		return contact.stream().map(x -> entitytodto(x)).collect(Collectors.toList());
	}
	
	public Contact dtotoentity(ContactDto dto) {
		Contact contact=new Contact();
		contact.setId(dto.getId());
		contact.setFirstName(dto.getFirstName());
		contact.setContactNo(contact.getContactNo());
		contact.setStatus(dto.getStatus());
		contact.setMailId(dto.getMailId());
		contact.setAddress(dto.getAddress());
		return contact;
	}
	
	public List<Contact> dtotoentity(List<ContactDto> dto) {

		return dto.stream().map(x -> dtotoentity(x)).collect(Collectors.toList());
	}
}
