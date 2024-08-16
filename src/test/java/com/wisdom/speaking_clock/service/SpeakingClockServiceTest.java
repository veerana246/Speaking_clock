package com.wisdom.speaking_clock.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SpeakingClockServiceTest {

    private final SpeakingClockService speakingClockService = new SpeakingClockService();

    @Test
    public void testMidnight() {
        LocalTime midnight = LocalTime.of(0, 0);
        assertEquals("It's Midnight", speakingClockService.convertTimeToWords(midnight));
    }

    @Test
    public void testMidday() {
        LocalTime midday = LocalTime.of(12, 0);
        assertEquals("It's Midday", speakingClockService.convertTimeToWords(midday));
    }

    @Test
    public void testSpecificTime() {
        LocalTime time = LocalTime.of(8, 34);
        assertEquals("It's eight thirty four", speakingClockService.convertTimeToWords(time));
    }

    @Test
    public void testNoon() {
        LocalTime noon = LocalTime.of(12, 30);
        assertEquals("It's twelve thirty", speakingClockService.convertTimeToWords(noon));
    }

    @Test
    public void testOneMinutePastNoon() {
        LocalTime time = LocalTime.of(12, 1);
        assertEquals("It's twelve one", speakingClockService.convertTimeToWords(time));
    }

    @Test
    public void testTwentyThreeFiftyNine() {
        LocalTime time = LocalTime.of(23, 59);
        assertEquals("It's twenty three fifty nine", speakingClockService.convertTimeToWords(time));
    }
}
