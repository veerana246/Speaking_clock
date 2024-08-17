package com.wisdom.speaking_clock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wisdom.speaking_clock.exception.InvalidTimeFormatException;
import com.wisdom.speaking_clock.service.SpeakingClockService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/time")
public class TimeController {

    @Autowired
    private SpeakingClockService speakingClockService;

    @GetMapping("/current")
    public ResponseEntity<String> getCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        String timeInWords = speakingClockService.convertTimeToWords(currentTime);
        return ResponseEntity.ok(timeInWords);
    }

    @GetMapping("/convert")
    public ResponseEntity<String> convertTime(@RequestParam("time") String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime inputTime = LocalTime.parse(time, formatter);
            String timeInWords = speakingClockService.convertTimeToWords(inputTime);
            return ResponseEntity.ok(timeInWords);
        } catch (DateTimeParseException ex) {
            throw new InvalidTimeFormatException("The entered time is invalid. It should be in 24-hour format (HH:mm).");
        }
    }
}
