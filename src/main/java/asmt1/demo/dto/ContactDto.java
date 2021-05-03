package asmt1.demo.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import asmt1.demo.entity.Address;

public class ContactDto {

	private long id;
	private String firstName;
	private String lastName;
	private long contactNo;
	private String mailId;	
	private UserStatus status;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<Address> address=new HashSet<>();
	
	public ContactDto(String firstName, String lastName, long contactNo, String mailId, UserStatus status,
			Set<Address> address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.mailId = mailId;
		this.status = status;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public ContactDto() {
		
	}

	@Override
	public String toString() {
		return "ContactDto [firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", mailId=" + mailId + ", status=" + status + "]";
	}


}
