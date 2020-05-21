package com.course.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.constant.Constant;
import com.course.dto.CourseNameList;
import com.course.dto.CourseResponseDto;
import com.course.dto.PurchaseDetailDto;
import com.course.dto.PurchaseDetailResponseDto;
import com.course.dto.ResponseDto;
import com.course.dto.purchaseCourseDto;
import com.course.service.CourseService;

@RestController
@RequestMapping("/cor")

public class CourseController {
	
	@Autowired
	private CourseService cs;
	
	
	
	@PostMapping("/courses/purchase")
	public ResponseEntity<ResponseDto>purchaseCourse(@RequestBody purchaseCourseDto purchase){
	
		ResponseDto response=cs.purchase(purchase);
		
		
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/purchasecourses/{userId}/course")
	public ResponseEntity<PurchaseDetailResponseDto>getpurchaseDetail(@PathVariable Long userId){
		List<PurchaseDetailDto> details=cs.getPurchaseDetail(userId);
		if(details!=null) {
			PurchaseDetailResponseDto dto=new PurchaseDetailResponseDto();
			dto.setMessage(Constant.COURSE_DETAIL);
			dto.setStatuscode(Constant.SuccessStatusCode);
			dto.setDetails(details);
			
		return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		PurchaseDetailResponseDto dto=new PurchaseDetailResponseDto();
		return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("courses/purchaseCoursesDetail/{userId}")
	public ResponseEntity<List<PurchaseDetailDto>> getPurchaseDetail(@PathVariable Long userId){
		List<PurchaseDetailDto> dto=cs.getPurchaseCourseDetail(userId);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	////this controller is not working //////s
	
	@GetMapping("/course/{courseName}/courses")
	public ResponseEntity<CourseResponseDto> getCourseDetail(@RequestParam String courseName){
		
		CourseResponseDto course=new CourseResponseDto();
		
		List<CourseNameList> dto=cs.getCourse(courseName);
		if(dto.isEmpty()) {
			course.setStatusCode(Constant.ERROR_CODE);
			return new ResponseEntity<>(course,HttpStatus.NOT_FOUND);
		}
		course.setCourseList(dto);
		course.setStatusCode(Constant.SuccessStatusCode);
		System.out.println(course);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	// this is working ....///
	@GetMapping("/courseByName/{courseName}/courses")
	public ResponseEntity<CourseResponseDto> getCourseName(@PathVariable String courseName){
		
		CourseResponseDto course=new CourseResponseDto();
		
		List<CourseNameList> dto=cs.getCourse(courseName);
		if(dto.isEmpty()) {
			course.setStatusCode(Constant.ERROR_CODE);
			return new ResponseEntity<>(course,HttpStatus.NOT_FOUND);
		}
		course.setCourseList(dto);
		course.setStatusCode(Constant.SuccessStatusCode);
		System.out.println(course);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
}
