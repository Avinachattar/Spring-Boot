package com.zensar.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.spring.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("FROM User U WHERE U.email = :email")
	User getByEmail(@Param("email") String email);


}
