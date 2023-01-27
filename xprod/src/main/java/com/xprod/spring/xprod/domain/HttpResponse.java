package com.xprod.spring.xprod.domain;

import org.springframework.http.HttpStatus;

public class HttpResponse {
	
	private int httpStatusCode;  //200, 201, 400, 500
	private HttpStatus httpStatus;
	private String reason;
	private String message;
	
	
	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getReason() {
		return reason;
	}

	public String getMessage() {
		return message;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpResponse() {
		super();
	}

	public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
		super();
		this.httpStatusCode = httpStatusCode;
		this.httpStatus = httpStatus;
		this.reason = reason;
		this.message = message;
	}
	
	
	

}
