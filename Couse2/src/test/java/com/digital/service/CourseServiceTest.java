package com.digital.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.course.Exception.PurchaseDetailNotFoundException;

import com.course.dto.PurchaseDetailDto;
import com.course.dto.PurchaseDetailResponseDto;
import com.course.dto.ResponseDto;
import com.course.dto.purchaseCourseDto;
import com.course.entity.Course;
import com.course.entity.PurchaseCourse;
import com.course.repo.CourseRepo;
import com.course.repo.PurchaseRepo;
import com.course.service.CourseServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseServiceTest {
	
	@Mock
	PurchaseRepo repo;
	
	@Mock
	CourseRepo crepo;
	
	@InjectMocks
	CourseServiceImpl impl;
	
	List<PurchaseCourse>purchaseCourse=null;
	PurchaseCourse purchase=null;
	purchaseCourseDto purchaseDto=null;
	Course course=null;
	
	ResponseDto reponse=null;
	PurchaseDetailResponseDto purchasedetailresponse=null;
	
	List<PurchaseDetailDto> purchaseDetail=null;
	List<PurchaseDetailDto> purchaseDetail1=null;
	PurchaseDetailDto detail=null;
	
	@Before
	public void before() {
		purchaseCourse=new ArrayList<>();
		
		purchase=new PurchaseCourse();
		purchase.setCourseId(100L);
		purchase.setCourseName("java");
		purchase.setPurchaseId(100L);
		purchase.setQuantity(1);
		purchase.setUserId(100L);
		purchaseCourse.add(purchase);
		
		purchaseDetail=new ArrayList<>();
		detail=new PurchaseDetailDto();
		detail.setCourseId(100L);
		detail.setCourseName("spring");
		purchaseDetail.add(detail);
		
		course=new Course();
		course.setCourseId(100L);
		
		reponse=new ResponseDto();
		reponse.setStatusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void testPurchaseCourse() {
		Mockito.when(crepo.findById(100L)).thenReturn(Optional.of(course));
		Mockito.when(crepo.save(course)).thenReturn(course);
		assertNotNull(reponse);
	}
	
	
	@Test
	public void testPurchaseDetail() {
		Long userId=100L;
		Mockito.when(repo.findByUserId(userId)).thenReturn(purchaseCourse);
		List<PurchaseDetailDto> response=impl.getPurchaseDetail(userId);
		assertEquals(purchaseCourse.size(), response.size());
		
	}
	@Test(expected = PurchaseDetailNotFoundException.class)
	public void testPurchaseDetailNegative() {
		Long userId=100L;
		Mockito.when(repo.findByUserId(userId)).thenReturn(purchaseCourse);
		impl.getPurchaseDetail(200L);
		
		
	}
	
	
}
