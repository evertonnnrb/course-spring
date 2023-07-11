package com.dv.course.exceptions;

public class OrderStatusCodesInvalidException extends RuntimeException{
    public OrderStatusCodesInvalidException(String message) {
        super(message);
    }
}
