package asmt1.demo.dto;

import asmt1.demo.entity.Address;
import asmt1.demo.entity.Contact;

public class AddressReq {

	
	private Address address;
	private Contact contact;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	

	public AddressReq(Address address, Contact contact) {
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
