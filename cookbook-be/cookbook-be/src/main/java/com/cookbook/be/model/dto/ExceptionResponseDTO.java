package com.cookbook.be.model.dto;

public class ExceptionResponseDTO {
String errorCode;
String message;



public ExceptionResponseDTO(String errorCode, String message) {
	this.errorCode = errorCode;
	this.message = message;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
