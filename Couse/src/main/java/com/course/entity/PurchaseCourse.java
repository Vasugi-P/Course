package com.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class PurchaseCourse{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseId;
	private Long courseId;
	private String courseName;
	private Long userId;
	private int quantity;
	
	public PurchaseCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*public PurchaseCourse(Long courseId, String courseName, Long userId, int quantity) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.userId = userId;
		this.quantity = quantity;
	}*/

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
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
	
	
	
	
	

}
