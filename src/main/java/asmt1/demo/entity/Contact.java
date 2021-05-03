package asmt1.demo.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;   
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import asmt1.demo.dto.UserStatus;
//@Entity annotation specifies that the class is an entity and is mapped to a database table.
//@Table annotation specifies the name of the database table to be used for mapping
@Entity
@Table(name="Contactdetail")
public class Contact {
	//@Id is used to specify the primarykey
	@Id
	//Generated value is used to generate pk value ie. id to be autogenerated and assign identity coulumn(id)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//@column is used to specify the column condition
	//@Column( unique = true)  
	private String firstName;	
	
	private String lastName;
	//@Column(unique = true)
	private long contactNo;
	private String mailId;
	
	//list of named constant ie. status
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	//it is used to create one-to-one relationship between the contact and address table
	//fetch type.lazy tells Hibernate to only fetch the related entities from the database when you use the relationship
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="conadd",
				joinColumns = {@JoinColumn(name="id")},
				inverseJoinColumns = {@JoinColumn(name="addid")})
	//To handle the problem related to the serialization of the model using Jackson API when the model attributes have a lazy loading defined,
	//we have to tell the serializer to ignore the chain or helpful garbage that Hibernate adds to classes, so it can manage lazy loading of data by declaring @JsonIgnoreProperties
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Set<Address> address=new HashSet<>();

	//generate getters,setters, toString() and constructor using fields
	
	public Contact() {}
	
	public Contact(String firstName, String lastName, long contactNo, String mailId, UserStatus status,
			Set<Address> address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.mailId = mailId;
		this.status = status;
		this.address = address;
	}

	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
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

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", mailId=" + mailId + "]";
	}
}
