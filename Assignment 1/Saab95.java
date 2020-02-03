import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(Color color) {
        super("Saab95", 2, color, 125);
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
