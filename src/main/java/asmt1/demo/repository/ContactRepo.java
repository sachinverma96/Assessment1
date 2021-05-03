package asmt1.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import asmt1.demo.entity.Contact;

//It is used in java class which directly access the database
@Repository
public interface ContactRepo extends JpaRepository<Contact, Long>{
	 public List<Contact> findAllByOrderByIdDesc();
}


