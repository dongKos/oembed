package com.pw.oembed.dto;

import java.io.Serializable;

import com.pw.oembed.enumaration.Host;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String url;
	
	public Host getHost() {
		if(this.url.contains("youtube.com"))
			return Host.Youtube;
		if(this.url.contains("instagram.com"))
			return Host.Instagram;
		if(this.url.contains("twitter.com"))
			return Host.Twitter;
		return Host.Vimeo;
	}

}
