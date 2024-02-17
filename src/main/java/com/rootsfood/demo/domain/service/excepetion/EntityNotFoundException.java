package com.rootsfood.demo.domain.service.excepetion;

public class EntityNotFoundException extends RuntimeException {

    EntityNotFoundException(String message) {
        super(message);
    }
}
