package com.lfaiska.velazques.restPresentation;

import com.lfaiska.velazques.restPresentation.entity.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public @ResponseBody ErrorResponse defaultHandler(Exception ex) {
        return new ErrorResponse(ex.toString());
    }
}
