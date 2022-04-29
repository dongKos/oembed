package com.pw.oembed.enumaration;

import lombok.Getter;

@Getter
public enum Host {
	Twitter("https://publish.twitter.com/oembed?url="),
	Youtube("https://www.youtube.com/oembed?url="),
	Instagram(""),
	Vimeo("https://vimeo.com/api/oembed.json?url=");
	
	private String prefixUrl;
	Host(String prefixUrl) {
		this.prefixUrl = prefixUrl;
	}
	
}
