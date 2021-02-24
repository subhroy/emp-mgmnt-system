package com.employees.mgmnt.system.exceptions;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String msg) {
    super(msg);
  }

  public NotFoundException(String msg, Throwable e) {
    super(msg, e);
  }
}
