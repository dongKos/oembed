package com.pw.oembed.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pw.oembed.dto.SearchRequest;
import com.pw.oembed.dto.SearchResult;
import com.pw.oembed.service.OembedService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OembedController {
	
	private final OembedService oembedService;

	@GetMapping("/search")
	public SearchResult searchOembed(String url) throws Exception {
		SearchResult searchResult = oembedService.searchOembed(url);
		log.info("searchResult : {}",searchResult.toString());
		return searchResult;
	}
	
	
}
