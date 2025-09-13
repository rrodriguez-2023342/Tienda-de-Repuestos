package com.robertorodriguez.proyectorepuestos.controller;

public class InvalidEmail extends RuntimeException {
    public InvalidEmail(String message) {
        super(message);
    }
}
