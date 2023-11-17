package com.poc.spring.exception;

import com.poc.spring.domain.response.AppResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(ModelAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public AppResponse handleModelNotFoundException(final ModelAlreadyExistsException ex) {
        log.error("Model Already Exist exception thrown; {} ", ex.getMessage());

        return new AppResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                 null, ex.getMessage());
    }

}
