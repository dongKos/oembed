package com.pw.oembed.util.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

	API_RESULT_NOT_VALID(500, "Oembed API 결과값이 유효하지 않습니다."),
    INSTAGREAM_NOT_SUPPORTED(400, "인스타그램 oEmbed는 지원하지 않습니다."),
    URL_NOT_VALID(400, "올바르지 않은 주소값 입니다."),
    API_TIMEOUT(504, "Oembed 서버에서 Timeout이 발생했습니다."),
    UNKNOWN_ERROR(500, "알 수 없는 에러입니다.");

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;
}
