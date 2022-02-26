package de.painer.fstools.hardware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HardwareController implements HardwareApi {

    private static final Logger log = LoggerFactory.getLogger(HardwareController.class);

    private final HardwareService service;

    private final SimpMessagingTemplate wsTemplate;

    public HardwareController(HardwareService service, SimpMessagingTemplate wsTemplate) {
        this.service = service;
        this.wsTemplate = wsTemplate;
    }

    @Override
    public HardwareStatus getStatus() {
        return service.getStatus();
    }

    @Override
    public HardwareStatus connect() {
        return service.connect();
    }

    @Override
    public HardwareStatus disconnect() {
        return service.disconnect();
    }

    @ServiceActivator(inputChannel = "hardwareStatus")
    public void wsHardwareStatus(HardwareStatus status) {
        log.debug("Sending status to WebSocket: {}", status);
        wsTemplate.convertAndSend("/topic/hardware", status);
    }

}
