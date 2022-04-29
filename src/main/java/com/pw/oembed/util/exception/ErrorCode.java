package com.pw.oembed.util.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

	API_RESULT_NOT_VALID(500, "Oembed API 결과값이 유효하지 않습니다."),
    INSTAGREAM_NOT_SUPPORTED(500, "인스타그램 oEmbed는 지원하지 않습니다."),
    URL_NOT_VALID(500, "올바르지 않은 주소값 입니다.");

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;
}
