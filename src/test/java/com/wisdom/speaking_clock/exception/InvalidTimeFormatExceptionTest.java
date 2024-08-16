package com.wisdom.speaking_clock.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvalidTimeFormatExceptionTest {

    @Test
    public void testExceptionMessage() {
        // Given
        String expectedMessage = "Invalid time format";
        
        // When
        InvalidTimeFormatException exception = new InvalidTimeFormatException(expectedMessage);
        
        // Then
        assertEquals(expectedMessage, exception.getMessage(), "Exception message should match the expected message");
    }

    @Test
    public void testExceptionIsThrown() {
        // Given
        String expectedMessage = "Invalid time format";
        
        // When / Then
        InvalidTimeFormatException exception = assertThrows(InvalidTimeFormatException.class, () -> {
            throw new InvalidTimeFormatException(expectedMessage);
        });
        
        // Assert
        assertEquals(expectedMessage, exception.getMessage(), "Exception message should match the expected message");
    }
}
