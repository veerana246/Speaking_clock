package com.wisdom.speaking_clock.exception;

import com.wisdom.speaking_clock.controller.TimeController;
import com.wisdom.speaking_clock.service.SpeakingClockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(TimeController.class)
public class GlobalExceptionHandlerTest {

	private MockMvc mockMvc;

	@MockBean
	private SpeakingClockService speakingClockService;

	@InjectMocks
	private TimeController timeController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(timeController).setControllerAdvice(new GlobalExceptionHandler())
				.build();
	}

	@Test
	public void testHandleDateTimeParseException() throws Exception {
		// Simulate a request that would lead to DateTimeParseException
		String invalidTime = "25:61"; // Example invalid time format

		// This should match the controller method that would throw
		// DateTimeParseException
		mockMvc.perform(get("/api/time/convert").param("time", invalidTime)).andExpect(status().isBadRequest())
				.andExpect(content().string("The entered time is invalid. It should be in 24-hour format (HH:mm)."));
	}

	@Test
	public void testHandleInvalidTimeFormatException() throws Exception {

		LocalTime date = LocalTime.parse("14:00");
		// Simulate service layer throwing InvalidTimeFormatException
		when(speakingClockService.convertTimeToWords(date))
				.thenThrow(new InvalidTimeFormatException("Invalid time format. Please use the HH:mm format."));

		// This should match the controller method that calls the service
		mockMvc.perform(get("/api/time/convert").param("time", "invalid")).andExpect(status().isBadRequest())
				.andExpect(content().string("The entered time is invalid. It should be in 24-hour format (HH:mm)."));
	}
}
