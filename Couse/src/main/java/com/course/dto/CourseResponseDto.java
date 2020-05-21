package com.course.dto;

import java.util.List;

public class CourseResponseDto {
	
	private List<CourseNameList> courseList;
	Integer StatusCode;
	
	public List<CourseNameList> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<CourseNameList> courseList) {
		this.courseList = courseList;
	}
	public Integer getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(Integer statusCode) {
		StatusCode = statusCode;
	}
	
	

}
