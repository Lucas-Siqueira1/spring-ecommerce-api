package com.lucas.spring_ecommerce_api.services.exceptions;

import org.apache.logging.log4j.spi.ObjectThreadContextMap;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
