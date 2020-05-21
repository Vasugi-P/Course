package com.course.dto;

import org.springframework.hateoas.Link;

import com.course.entity.PurchaseCourse;

public class ResponseDto {
	
	Integer statusCode;
	String message;
	
	
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
