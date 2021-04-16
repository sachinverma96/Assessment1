package asmt1.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
//@Entity annotation specifies that the class is an entity and is mapped to a database table.
//@Table annotation specifies the name of the database table to be used for mapping

@Entity
@Table(name="addressdetails")
public class Address {
	//@Id is used to specify the primarykey
		@Id
		private long id;
		private String street1;
		private String street2;
		private long zipcode;
		private String city;
		private String state;
		private String Country;
		//mappedby is used to specify to relationship
		@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="address")
		private Contact contact;

		//generate getters,setters, toString() and constructor using fields
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getStreet1() {
			return street1;
		}

		public void setStreet1(String street1) {
			this.street1 = street1;
		}

		public String getStreet2() {
			return street2;
		}

		public void setStreet2(String street2) {
			this.street2 = street2;
		}

		public long getZipcode() {
			return zipcode;
		}

		public void setZipcode(long zipcode) {
			this.zipcode = zipcode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return Country;
		}

		public void setCountry(String country) {
			Country = country;
		}

		public Address(String street1, String street2, long zipcode, String city, String state, String country) {
			super();
			this.street1 = street1;
			this.street2 = street2;
			this.zipcode = zipcode;
			this.city = city;
			this.state = state;
			Country = country;
		}
		public Address() {}
		 
	}
