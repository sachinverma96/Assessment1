package com.example.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}
