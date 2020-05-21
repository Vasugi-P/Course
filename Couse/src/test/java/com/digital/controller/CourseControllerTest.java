package com.digital.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.course.Exception.CourseIdNotFoundException;
import com.course.dto.PurchaseDetailDto;
import com.course.dto.PurchaseDetailResponseDto;
import com.course.dto.ResponseDto;
import com.course.dto.purchaseCourseDto;
import com.course.entity.PurchaseCourse;
import com.course.service.CourseService;
import com.course.web.CourseController;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseControllerTest {
	
	@Mock
	CourseService service;
	
	@InjectMocks
	CourseController courseController;
	
	PurchaseCourse purchase=null;
	purchaseCourseDto purchaseDto=null;
	
	ResponseDto reponse=null;
	PurchaseDetailResponseDto purchasedetailresponse=null;
	
	List<PurchaseDetailDto> purchaseDetail=null;
	List<PurchaseDetailDto> purchaseDetail1=null;
	PurchaseDetailDto detail=null;
	
	@Before
	public void before() {
		purchase=new PurchaseCourse();
		purchase.setCourseId(100L);
		purchase.setCourseName("java");
		purchase.setPurchaseId(100L);
		purchase.setQuantity(1);
		purchase.setUserId(100L);
		
		
		purchaseDetail=new ArrayList<>();
		detail=new PurchaseDetailDto();
		detail.setCourseId(100L);
		detail.setCourseName("spring");
		purchaseDetail.add(detail);
		
		
		reponse=new ResponseDto();
		reponse.setStatusCode(HttpStatus.OK.value());
		
		purchasedetailresponse=new PurchaseDetailResponseDto();
		
		
		
	}
	@Test
	public void testPurchaseCourse() {
		Mockito.when(service.purchase(purchaseDto)).thenReturn(reponse);
		ResponseEntity<ResponseDto> expected=courseController.purchaseCourse(purchaseDto);
		assertEquals(HttpStatus.OK, expected.getStatusCode());
	}
	
	@Test
	public void testPurchaseDetail() {
		Long courseId=100L;
		Mockito.when(service.getPurchaseDetail(courseId)).thenReturn(purchaseDetail);
		ResponseEntity<PurchaseDetailResponseDto> response=courseController.getpurchaseDetail(courseId);
		assertEquals(response.getStatusCode(),HttpStatus.OK );
		
	}

	@Test
	public void testPurchaseDetailNegative()throws CourseIdNotFoundException {
		Long courseId=100L;
		Mockito.when(service.getPurchaseDetail(courseId)).thenReturn(purchaseDetail1);
		ResponseEntity<PurchaseDetailResponseDto> response=courseController.getpurchaseDetail(courseId);
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND );
		
	}
	

}
