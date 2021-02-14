package com.study.webflux.error;

import com.study.webflux.exception.GlobalException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(request, options);

        if (getError(request) instanceof GlobalException) {
            GlobalException ex = (GlobalException) getError(request);
            errorAttributes.put("exception", ex.getClass().getSimpleName());
            errorAttributes.put("message", ex.getMessage());
            errorAttributes.put("status", ex.getStatus().value());
            errorAttributes.put("error", ex.getStatus().getReasonPhrase());

            return errorAttributes;
        }

        errorAttributes.put("exception", HttpStatus.INTERNAL_SERVER_ERROR);
        errorAttributes.put("message", "시스템 오류가 발생했습니다.");
        errorAttributes.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorAttributes.put("error", "시스템 오류가 발생했습니다.");

        return errorAttributes;
    }
}
