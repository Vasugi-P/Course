package com.course.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.course.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{
	
	List<Course> findByCourseId(Long courseId);
	
	
	List<Course> findByCourseNameContaining(String courseName);

	List<Course>findByCourseNameContains(String courseName);
}
