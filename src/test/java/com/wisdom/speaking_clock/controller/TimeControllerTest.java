package com.wisdom.speaking_clock.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import com.wisdom.speaking_clock.service.SpeakingClockService;

import java.time.LocalTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(TimeController.class)
public class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpeakingClockService speakingClockService;

    @Test
    public void testGetCurrentTime() throws Exception {
        LocalTime currentTime = LocalTime.of(10, 15);
        when(speakingClockService.convertTimeToWords(currentTime)).thenReturn("It's ten fifteen");

//        mockMvc.perform(get("/api/time/current"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("It's ten fifteen"));
    }

    @Test
    public void testConvertTime() throws Exception {
        String time = "08:34";
        when(speakingClockService.convertTimeToWords(LocalTime.of(8, 34))).thenReturn("It's eight thirty four");

        mockMvc.perform(get("/api/time/convert").param("time", time))
                .andExpect(status().isOk())
                .andExpect(content().string("It's eight thirty four"));
    }

    @Test
    public void testInvalidTimeFormat() throws Exception {
        String invalidTime = "25:00";

        mockMvc.perform(get("/api/time/convert").param("time", invalidTime))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("The entered time is invalid. It should be in 24-hour format (HH:mm)."));
    }

    @Test
    public void testEmptyTime() throws Exception {
        mockMvc.perform(get("/api/time/convert").param("time", ""))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("The entered time is invalid. It should be in 24-hour format (HH:mm)."));
    }
}
