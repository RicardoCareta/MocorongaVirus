package com.rd.mocoronga.backend.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {
	
	private String message;
	private HttpStatus status;
	private ZonedDateTime dateTime;
	
	public ApiError(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
		this.dateTime = ZonedDateTime.now();
	}
	
	public String getMessage() {
		return message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public ZonedDateTime getDateTime() {
		return dateTime;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public void setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
