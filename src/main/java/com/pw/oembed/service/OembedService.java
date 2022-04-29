package com.pw.oembed.service;

import com.pw.oembed.dto.SearchResult;

public interface OembedService {

	SearchResult searchOembed(String url) throws Exception;

}
