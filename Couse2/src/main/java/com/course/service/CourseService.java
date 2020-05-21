package com.course.service;

import java.util.List;

import com.course.dto.CourseNameList;
import com.course.dto.PurchaseDetailDto;
import com.course.dto.ResponseDto;
import com.course.dto.purchaseCourseDto;


public interface CourseService {
	
	
	ResponseDto purchase(purchaseCourseDto purchaseCourse);
	
	public List<PurchaseDetailDto>getPurchaseDetail(Long userId);
	
	List<PurchaseDetailDto> getPurchaseCourseDetail(Long userId);
	
	List<CourseNameList> getCourse(String courseName);
	
	List<CourseNameList>getCourseByCourseName(String  courseName);
	

}
