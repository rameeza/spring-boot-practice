package com.rameez.spring_boot_practice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource that you requested was not found")
public class ResourceNotFoundException extends RuntimeException {

}
