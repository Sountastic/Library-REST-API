package com.project.library.api.exceptions;

public class BookEditionNotFoundException extends Exception{
    public String toString() {
        return "Book edition not found!";
    }
}
