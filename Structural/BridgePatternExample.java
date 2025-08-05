package Structural;
// 1. Implementation (Bridge Implementor)
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int percent);
}

// 2. Concrete Implementations
class TV implements Device {
    public void turnOn() {
        System.out.println("TV turned ON");
    }
    public void turnOff() {
        System.out.println("TV turned OFF");
    }
    public void setVolume(int percent) {
        System.out.println("TV volume set to " + percent + "%");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio turned ON");
    }
    public void turnOff() {
        System.out.println("Radio turned OFF");
    }
    public void setVolume(int percent) {
        System.out.println("Radio volume set to " + percent + "%");
    }
}

// 3. Abstraction
abstract class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }

    abstract void togglePower();
    abstract void volumeUp();
    abstract void volumeDown();
}

// 4. Refined Abstraction
class BasicRemote extends Remote {
    private boolean isOn = false;
    private int volume = 50;

    public BasicRemote(Device device) {
        super(device);
    }

    public void togglePower() {
        if (isOn) {
            device.turnOff();
            isOn = false;
        } else {
            device.turnOn();
            isOn = true;
        }
    }

    public void volumeUp() {
        volume += 10;
        device.setVolume(volume);
    }

    public void volumeDown() {
        volume -= 10;
        device.setVolume(volume);
    }
}

// 5. Client
public class BridgePatternExample {
    public static void main(String[] args) {
        Device tv = new TV();
        Remote tvRemote = new BasicRemote(tv);

        tvRemote.togglePower();
        tvRemote.volumeUp();
        tvRemote.volumeDown();
        tvRemote.togglePower();

        System.out.println();

        Device radio = new Radio();
        Remote radioRemote = new BasicRemote(radio);

        radioRemote.togglePower();
        radioRemote.volumeUp();
        radioRemote.volumeDown();
        radioRemote.togglePower();
    }
}

