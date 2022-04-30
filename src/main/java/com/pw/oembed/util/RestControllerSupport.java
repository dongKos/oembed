package com.pw.oembed.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class RestControllerSupport {
	
	protected HttpHeaders httpHeader;
	
	public RestControllerSupport() {
		httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
	}

}
