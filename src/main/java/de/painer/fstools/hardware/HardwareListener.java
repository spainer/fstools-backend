package de.painer.fstools.hardware;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "hardwareStatus")
public interface HardwareListener {

    void statusChanged(HardwareStatus status);

}
