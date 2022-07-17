package com.mpdgr.sudokusolver.controller;

public class InvalidInputException extends Exception{
    public InvalidInputException(String message) {
        super(message);
    }
}
