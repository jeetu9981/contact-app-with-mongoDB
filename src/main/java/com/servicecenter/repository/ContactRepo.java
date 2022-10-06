package com.servicecenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.servicecenter.entities.Contact;

public interface ContactRepo extends CrudRepository<Contact,Integer>{
	@Query(value="select * from contacts where user_id=:userId",nativeQuery = true)
	public List<Contact> findbyUserId(@Param("userId") String userId);
}
