package com.project.library.api.exceptions;

public class RentalNotFoundException extends Exception {
    public String toString() {
        return "Rental not found!";
    }
}
