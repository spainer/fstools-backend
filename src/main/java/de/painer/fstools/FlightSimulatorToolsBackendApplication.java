package de.painer.fstools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class FlightSimulatorToolsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightSimulatorToolsBackendApplication.class, args);
    }

}
