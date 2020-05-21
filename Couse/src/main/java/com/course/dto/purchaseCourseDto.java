package com.course.dto;



public class purchaseCourseDto {
	
	
	private String courseName;
	
	private Long userId;
	private int quantity;
	private Long courseId;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
	
	
}
