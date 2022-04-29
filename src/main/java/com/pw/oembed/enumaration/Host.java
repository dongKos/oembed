package com.pw.oembed.enumaration;

public enum Host {
	Twitter("https://publish.twitter.com/oembed?url="),
	Youtube("https://www.youtube.com/oembed?url="),
	Instagram(""),
	Vimeo("https://vimeo.com/api/oembed.json?url=");
	
	private String prefixUrl;
	Host(String prefixUrl) {
		this.prefixUrl = prefixUrl;
	}
	
	public String getPrefixUrl() {
		return this.prefixUrl;
	}
}
