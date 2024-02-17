package com.rootsfood.demo.domain.service.excepetion;

public class KitchenNotFoundException extends EntityNotFoundException {

    KitchenNotFoundException(String message) {
        super(message);
    }

    public KitchenNotFoundException(Long id) {
        this(String.format("Kitchen with id: %d, not found", id));
    }
}
