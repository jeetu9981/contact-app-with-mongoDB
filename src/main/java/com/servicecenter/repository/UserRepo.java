package com.servicecenter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.servicecenter.entities.User;

public interface UserRepo extends MongoRepository<User,Integer>{
	
	@Query(value="{'_id' : :#{#userId}}")
	public User findUser(String userId);
	
	@Query(value="{'_id' : :#{#userId}}",delete = true)
	public User deleteById(String userId);
}
