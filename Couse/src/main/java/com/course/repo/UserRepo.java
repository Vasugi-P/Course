package com.course.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	public Optional<User> findByUserId(Long userId);
	
	

}
