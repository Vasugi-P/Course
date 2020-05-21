package com.course.dto;

import java.util.List;

public class PurchaseDetailResponseDto {
	
	Integer statuscode;
	String message;
	private List<PurchaseDetailDto> details;
	
	public Integer getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<PurchaseDetailDto> getDetails() {
		return details;
	}
	public void setDetails(List<PurchaseDetailDto> details) {
		this.details = details;
	}
	
	

}
