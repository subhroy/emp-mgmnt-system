package com.employees.mgmnt.system.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class ServiceExceptionHandler {

  @ExceptionHandler(value = NotFoundException.class)
  ResponseEntity<ServiceExceptionMessage> handleNotFoundException(
      NotFoundException e, WebRequest request) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(
            ServiceExceptionMessage.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .errorStatus(HttpStatus.NOT_FOUND.name())
                .build());
  }
}
