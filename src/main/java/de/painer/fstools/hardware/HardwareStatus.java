package de.painer.fstools.hardware;

import org.springframework.lang.NonNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    description = "Hardware status."
)
public record HardwareStatus (
        @Schema(
            description = "Is hardware currently connected?"
        )
        @NonNull boolean connected,

        @Schema(
            description = "Serial number of hardware."
        )
        String serialNumber
    ){ }
