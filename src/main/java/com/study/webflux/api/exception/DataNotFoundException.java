package com.study.webflux.api.exception;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends GlobalException {

    public DataNotFoundException() {
        super(HttpStatus.NOT_FOUND, "조회된 데이터가 없습니다.");
    }

    public DataNotFoundException(HttpStatus status) {
        super(status);
    }

    public DataNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public DataNotFoundException(String message, Throwable e) {
        super(HttpStatus.NOT_FOUND, message, e);
    }

    public DataNotFoundException(HttpStatus status, String message, Throwable e) {
        super(status, message, e);
    }
}
