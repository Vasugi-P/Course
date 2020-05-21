package com.course.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.PurchaseCourse;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseCourse, Long>{
	
	List<PurchaseCourse> findByUserId(Long userId);

}
