package asmt1.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import com.sun.el.stream.Optional;

import asmt1.demo.dto.UserStatus;
import asmt1.demo.entity.Address;
import asmt1.demo.entity.Contact;
import asmt1.demo.repository.ContactRepo;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ContactTest {

	@Autowired
	ContactRepo ctrepo;
	
	@Test
	@Order(1)
    public void testSaveNewContact() {
		Address add=new Address("102", "Galaxy ", 12310, "LasVegas", "Goa", "India");
		UserStatus status=UserStatus.ACTIVE;
		Contact contact=new Contact("Shawn", "Micheal", 354535410, "shawn@gmail.com", status, add);
		Contact contactsave=ctrepo.save(contact);
		assertNotNull(contactsave);
	}
	@Test
	@Order(2)
	public void findbyid() {
		Long id= 1l;
		java.util.Optional<Contact> contact=ctrepo.findById(id);
	assertThat(contact.get()).isEqualTo(id);
	}
	
	@Test	
	@Order(3)
	public void findbyidnotpresent() {
		Long id= 1l;
		java.util.Optional<Contact> contact=ctrepo.findById(id);
		assertNull(contact);
	}
	
	@Test
	@Rollback(false)
	@Order(4)
	public void updatecontact() {
		Long id=2l;
		String firstName="gollu";
		Address add=new Address("102", "Galaxy ", 12310, "LasVegas", "Goa", "India");
		UserStatus status=UserStatus.ACTIVE;
		Contact contact=new Contact(firstName, "Micheal", 354535410, "shawn@gmail.com", status, add); 
		contact.setId(2);
		ctrepo.save(contact);
		java.util.Optional<Contact> contactup=ctrepo.findById(id);
		assertThat(contactup.get()).isEqualTo(id);
	}
	@Test
	@Order(5)
	public void testlistcontacts() {
		List<Contact> contacts=ctrepo.findAll();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		assertThat(contacts).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	@Order(6)
	public void testdeletecontact() {
		Long id=1l;
		boolean isexistingbeforedelete=ctrepo.findById(id).isPresent();
		ctrepo.deleteById(id);
		boolean notexistingafterdelete=ctrepo.findById(id).isPresent();
		assertTrue(isexistingbeforedelete);
		assertFalse(notexistingafterdelete);
	}    
}

