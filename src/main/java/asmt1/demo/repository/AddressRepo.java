package asmt1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import asmt1.demo.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
