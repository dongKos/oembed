package com.pw.oembed.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pw.oembed.service.OembedService;
import com.pw.oembed.util.exception.BusinessException;
import com.pw.oembed.util.exception.ErrorCode;

@SpringBootTest
class OembedServiceImplTest {
	
	@Autowired OembedService oembedService;

	@Test
	@DisplayName("유튜브, 트위터, 비메오 아닌 url은 에러를 발생시킨다")
	void test() {
		//given
		String notValidUrl = "www.notvalid.com";
		
		//when
		BusinessException exception = assertThrows(BusinessException.class, 
				() -> oembedService.searchOembed(notValidUrl));
		
		//then
		assertThat(exception.getMessage()).isEqualTo(ErrorCode.URL_NOT_VALID.getMessage());
	}
	
	@Test
	@DisplayName("유튜브, 트위터, 비메오 url은 에러를 발생시키지 않는다")
	void test2() {
		String youtube = "https://www.youtube.com/watch?v=dBD54EZIrZo";
		String twitter = "https://twitter.com/hellopolicy/status/867177144815804416";
		String vimeo = "https://vimeo.com/20097015";
		
		assertDoesNotThrow(() -> {
			oembedService.searchOembed(youtube);
		});
		assertDoesNotThrow(() -> {
			oembedService.searchOembed(twitter);
		});
		assertDoesNotThrow(() -> {
			oembedService.searchOembed(vimeo);
		});
	}

}
