package com.pw.oembed.util;

import org.springframework.stereotype.Component;

import com.pw.oembed.dto.SearchResult;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class HttpUtil {

	public SearchResult get(String url) throws Exception {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(url)
				.build();
		
		Response response = client.newCall(request).execute();
		String result = response.body().string();
		
		return new MyObjectMapper().readValue(result, SearchResult.class);
	}
}
