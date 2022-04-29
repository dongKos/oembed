package com.pw.oembed.util;

import org.springframework.stereotype.Component;

import com.pw.oembed.dto.SearchResult;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
@RequiredArgsConstructor
public class HttpUtil {

	private final MyObjectMapper mapper;
	
	public SearchResult get(String url) throws Exception {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(url)
				.build();
		Response response = client.newCall(request).execute();
		return mapper.readValue(response.body().string(), SearchResult.class);
	}
}
