package com.pw.oembed.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;

	public MyObjectMapper() {
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 없는 필드로 인한 오류 무시
		configure(Feature.AUTO_CLOSE_SOURCE, true);
	}
}