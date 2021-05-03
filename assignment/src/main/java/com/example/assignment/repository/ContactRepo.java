package com.example.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.assignment.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long>{

}
