package de.painer.fstools.hardware;

import org.springframework.stereotype.Service;

@Service
public class HardwareService {

    private final HardwareListener hardwareListener;

    private HardwareStatus currentStatus = new HardwareStatus(false, null);

    public HardwareService(HardwareListener hardwareListener) {
        this.hardwareListener = hardwareListener;
    }

    public HardwareStatus getStatus() {
        return currentStatus;
    }

    public HardwareStatus connect() {
        currentStatus = new HardwareStatus(true, "dummy");
        hardwareListener.statusChanged(currentStatus);
        return currentStatus;
    }

    public HardwareStatus disconnect() {
        currentStatus = new HardwareStatus(false, null);
        hardwareListener.statusChanged(currentStatus);
        return currentStatus;
    }

}
