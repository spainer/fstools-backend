package de.painer.fstools.hardware;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Hardware", description = "Endpoint for Hardware")
@RequestMapping("/hardware")
public interface HardwareApi {

    @Operation(
        summary = "Current status",
        description = "Request current hardware status.",
        responses = {
            @ApiResponse(
                description = "Current hardware status",
                responseCode = "200",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = HardwareStatus.class)
                )
            ),
            @ApiResponse(
                description = "Hardware not found",
                responseCode = "404",
                content = @Content
            )
        }
    )
    @GetMapping
    HardwareStatus getStatus();

    @Operation(
        summary = "Connect",
        description = "Connect to hardware.",
        responses = {
            @ApiResponse(
                description = "Connected successfully.",
                responseCode = "200",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = HardwareStatus.class)
                )
            ),
            @ApiResponse(
                description = "Hardware not found.",
                responseCode = "404",
                content = @Content
            ),
            @ApiResponse(
                description = "Error during connecting.",
                responseCode = "500",
                content = @Content
            )
        }
    )
    @PutMapping
    HardwareStatus connect();

    @Operation(
        summary = "Disconnect",
        description = "Disconnect from hardware.",
        responses = {
            @ApiResponse(
                description = "Disconnected successfully.",
                responseCode = "200",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = HardwareStatus.class)
                )
            ),
            @ApiResponse(
                description = "Hardware not found.",
                responseCode = "404",
                content = @Content
            ),
            @ApiResponse(
                description = "Error during disconnectiong.",
                responseCode = "500",
                content = @Content
            )
        }
    )
    @DeleteMapping
    HardwareStatus disconnect();

}
