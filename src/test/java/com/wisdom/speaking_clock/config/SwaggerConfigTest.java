package com.wisdom.speaking_clock.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import springfox.documentation.spring.web.plugins.Docket;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class SwaggerConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testSwaggerConfiguration() {
        // Check if the Docket bean is present in the application context
        Docket docket = applicationContext.getBean(Docket.class);
        assertNotNull(docket, "Docket bean should be present in the application context.");

        // Check if Swagger is enabled or disabled
        // Assuming Swagger is disabled as per the provided SwaggerConfig class
        assertFalse(docket.isEnabled(), "Swagger should be disabled according to SwaggerConfig.");
    }
}

