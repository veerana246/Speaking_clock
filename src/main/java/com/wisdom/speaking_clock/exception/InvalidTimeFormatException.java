package com.wisdom.speaking_clock.exception;

@SuppressWarnings("serial")
public class InvalidTimeFormatException extends RuntimeException {
	
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}
