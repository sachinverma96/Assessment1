package asmt1.demo.dto;

import java.util.HashSet;
import java.util.Set;

import asmt1.demo.entity.Address;
import asmt1.demo.entity.Contact;

public class AddressReq {

	
	private Set<Address> address=new HashSet<>();
	private Set<Contact> contact=new HashSet<>();


	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Contact> getContact() {
		return contact;
	}

	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}
	

	public AddressReq(Set<Address> address, Set<Contact> contact) {
		super();
		this.address = address;
		this.contact = contact;
	}
	public AddressReq() {}
	@Override
	public String toString() {
		return "AddressReq [address=" + address + ", contact=" + contact + "]";
	}


	
}
