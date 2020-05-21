package com.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.course.Exception.PurchaseDetailNotFoundException;
import com.course.Exception.UserIdNotFoundException;
import com.course.constant.Constant;
import com.course.dto.CourseNameList;
import com.course.dto.PurchaseDetailDto;
import com.course.dto.ResponseDto;
import com.course.dto.purchaseCourseDto;
import com.course.entity.Course;
import com.course.entity.PurchaseCourse;
import com.course.entity.User;
import com.course.repo.CourseRepo;
import com.course.repo.PurchaseRepo;
import com.course.repo.UserRepo;
import com.course.web.CourseController;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo crepo;

	@Autowired
	UserRepo urepo;

	@Autowired
	PurchaseRepo prepo;

	@Override
	public List<PurchaseDetailDto> getPurchaseDetail(Long userId) {
		List<PurchaseCourse> course = prepo.findByUserId(userId);
		List<PurchaseDetailDto> detail = new ArrayList<>();
		if (course.isEmpty()) {
			throw new PurchaseDetailNotFoundException();
		}
		course.forEach(courses -> {
			PurchaseDetailDto detailDto = new PurchaseDetailDto();
			BeanUtils.copyProperties(courses, detailDto);
			detail.add(detailDto);
		});
		return detail;
	}

	@Override
	public ResponseDto purchase(purchaseCourseDto purchaseCourse) {
		Optional<User> user = urepo.findByUserId(purchaseCourse.getUserId());
		if (!user.isPresent()) {
			throw new UserIdNotFoundException();
		}
		PurchaseCourse purchase = new PurchaseCourse();
		purchase.setUserId(purchaseCourse.getUserId());
		purchase.setCourseId(purchaseCourse.getCourseId());
		purchase.setCourseName(purchaseCourse.getCourseName());
		purchase.setQuantity(purchaseCourse.getQuantity());

		prepo.save(purchase);

		Optional<Course> course = crepo.findById(purchaseCourse.getCourseId());
		int reducedQuantity = purchaseCourse.getQuantity();
		course.get().setQuantity(course.get().getQuantity() - reducedQuantity);
		System.out.println(course);
		crepo.save(course.get());
		
		

		ResponseDto response = new ResponseDto();
		response.setMessage(Constant.message);
		response.setStatusCode(Constant.SuccessStatusCode);
		
		
		
		return response;
	}

	@Override
	public List<PurchaseDetailDto> getPurchaseCourseDetail(Long userId) {
		List<PurchaseCourse> course = prepo.findByUserId(userId);

		List<PurchaseDetailDto> purchaseDetail = course.stream().map(details -> {
			PurchaseDetailDto dto = new PurchaseDetailDto();
			BeanUtils.copyProperties(details, dto);
			return dto;

		}).collect(Collectors.toList());

		return purchaseDetail;

	}

	@Override
	public List<CourseNameList> getCourse(String courseName) {
		List<CourseNameList> course = new ArrayList<>();
		List<Course> course1 = crepo.findByCourseNameContaining(courseName);
		
		course1.forEach(courseDetails -> {
			CourseNameList dto = new CourseNameList();
			BeanUtils.copyProperties(courseDetails, dto);
			course.add(dto);
		});

		return course;
	
	}

	@Override
	public List<CourseNameList> getCourseByCourseName(String courseName) {
		List<CourseNameList> course = new ArrayList<>();
		List<Course> course1 = crepo.findByCourseNameContains(courseName);
		course1.forEach(courseDetails -> {
			CourseNameList dto = new CourseNameList();
			BeanUtils.copyProperties(courseDetails, dto);
			course.add(dto);
		});

		return course;
		
	}

}
