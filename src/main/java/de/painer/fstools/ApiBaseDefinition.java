package de.painer.fstools;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Flight Simulator Tools Backend",
        description = "Backend for Flight Simulator Tools.",
        version = "0.0.1"
    )
)
public final class ApiBaseDefinition {

    private ApiBaseDefinition() {
    }

}
