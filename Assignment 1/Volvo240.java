import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    public Volvo240(Color color) {
        super("Volvo240", 4, color, 100);
    }

    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
