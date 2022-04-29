package com.pw.oembed.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.pw.oembed.dto.SearchResult;
import com.pw.oembed.enumaration.Host;
import com.pw.oembed.service.OembedService;
import com.pw.oembed.util.HttpUtil;
import com.pw.oembed.util.exception.BusinessException;
import com.pw.oembed.util.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OembedServiceImpl implements OembedService {

	private final HttpUtil httpUtil;
	
	@Override
	public SearchResult searchOembed(String url) throws Exception {
		if(isInstagram(url)) 
			throw new BusinessException(ErrorCode.INSTAGREAM_NOT_SUPPORTED);
		
		if(!isValidUrl(url)) 
			throw new BusinessException(ErrorCode.URL_NOT_VALID);
		
		SearchResult searchResult = null;
		try {
			searchResult = httpUtil.get(getHost(url).getPrefixUrl() + url);
		} catch(JsonParseException e) {
			throw new BusinessException(ErrorCode.API_RESULT_NOT_VALID);
		} catch(Exception e) {
			throw new BusinessException(ErrorCode.UNKNOWN_ERROR);
		}
		return searchResult;
	}


	private boolean isInstagram(String url) {
		return url.startsWith("https://www.instagram.com") || url.startsWith("https://instagram.com");
	}
	
	private boolean isValidUrl(String url) {
		if(url.contains("youtube.com/") || url.contains("twitter.com/") || url.contains("vimeo.com/"))
			return true;
		return false;
	}
	
	private Host getHost(String url) {
		if(url.contains("youtube.com"))
			return Host.Youtube;
		if(url.contains("instagram.com"))
			return Host.Instagram;
		if(url.contains("twitter.com"))
			return Host.Twitter;
		return Host.Vimeo;
	}

}
