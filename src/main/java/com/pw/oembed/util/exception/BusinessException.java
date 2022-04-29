package com.pw.oembed.util.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getMessage());
	}
	
}
