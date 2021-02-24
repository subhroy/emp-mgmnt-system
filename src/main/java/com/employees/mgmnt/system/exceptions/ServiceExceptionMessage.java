package com.employees.mgmnt.system.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceExceptionMessage {
    private String message;
    private int statusCode;
    private String errorStatus;
}
