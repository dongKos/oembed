package com.pw.oembed.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pw.oembed.dto.SearchResult;
import com.pw.oembed.service.OembedService;
import com.pw.oembed.util.RestControllerSupport;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OembedController extends RestControllerSupport{
	
	private final OembedService oembedService;

	@GetMapping("/search")
	public ResponseEntity<SearchResult> searchOembed(String url) throws Exception {
		SearchResult searchResult = oembedService.searchOembed(url);
		return new ResponseEntity<SearchResult>(searchResult, httpHeader, HttpStatus.OK);
	}
	
	
}
