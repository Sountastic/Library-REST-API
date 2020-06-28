package com.project.library.api.exceptions;

public class UserNotFoundException extends Exception {
    public String toString() {
        return "User not found!";
    }
}
