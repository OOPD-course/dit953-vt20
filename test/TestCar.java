import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class TestCar {

    private Saab95 car;

    @Before
    public void init() {
        car = new Saab95(Color.BLACK);
    }

    @Test
    public void testGetNrDoors() {
        assertTrue(car.getNrDoors() == 2);
    }

    @Test
    public void testGetEnginePower() {
        assertTrue(car.getEnginePower() == 125);
    }

    @Test
    public void testSetAndGetCurrentSpeed() {
        car.setCurrentSpeed(20);
        assertTrue(car.getCurrentSpeed() == 20);
    }

    @Test
    public void testSetCurrentSpeed2() {
        car.setCurrentSpeed(-10);
        assertTrue(car.getCurrentSpeed() == 0);
    }

    @Test
    public void testSetCurrentSpeed3() {
        car.setCurrentSpeed(130);
        assertTrue(car.getCurrentSpeed() == 125);
    }

    @Test
    public void testGetAndSetColor() {
        car.setColor(Color.BLUE);
        assertTrue(car.getColor() == Color.BLUE);
    }

    @Test
    public void testStopEngine() {
        car.stopEngine();
        assertTrue(car.getCurrentSpeed() == 0);
    }

    @Test
    public void testStartEngine() {
        car.startEngine();
        assertTrue(car.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGas1() {
        car.setCurrentSpeed(0);
        car.gas(0.5);
        assertTrue(car.getCurrentSpeed() == 0.625);
    }

    @Test
    public void testGas2() {
        try {
            car.gas(-1);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGas3() {
        try {
            car.gas(2);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testBrake1() {
        car.setCurrentSpeed(5);
        car.brake(0.5);
        assertTrue(car.getCurrentSpeed() == 4.375);
    }

    @Test
    public void testBrake2() {
        try {
            car.brake(-1);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testBrake3() {
        try {
            car.brake(2);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testMove1() {
        car.setCurrentSpeed(1);
        car.move();
        assertTrue(car.getX() == 1 && car.getY() == 0);
    }

    @Test
    public void testMove2() {
        car.setCurrentSpeed(1);
        car.setCurDir(Car.Dir.DOWN);
        car.move();
        assertTrue(car.getX() == 0 && car.getY() == -1);
    }

    @Test
    public void testMove3() {
        car.setCurrentSpeed(1);
        car.setCurDir(Car.Dir.LEFT);
        car.move();
        assertTrue(car.getX() == -1 && car.getY() == 0);
    }

    @Test
    public void testMove4() {
        car.setCurrentSpeed(1);
        car.setCurDir(Car.Dir.UP);
        car.move();
        assertTrue(car.getX() == 0 && car.getY() == 1);
    }

    @Test
    public void testTurnLeft1() {
        car.turnLeft();
        assertTrue(car.getCurDir() == Car.Dir.UP);
    }

    @Test
    public void testTurnLeft2() {
        car.setCurDir(Car.Dir.DOWN);
        car.turnLeft();
        assertTrue(car.getCurDir() == Car.Dir.RIGHT);
    }

    @Test
    public void testTurnLeft3() {
        car.setCurDir(Car.Dir.LEFT);
        car.turnLeft();
        assertTrue(car.getCurDir() == Car.Dir.DOWN);
    }

    @Test
    public void testTurnLeft4() {
        car.setCurDir(Car.Dir.UP);
        car.turnLeft();
        assertTrue(car.getCurDir() == Car.Dir.LEFT);
    }

    @Test
    public void testTurnRight1() {
        car.turnRight();
        assertTrue(car.getCurDir() == Car.Dir.DOWN);
    }

    @Test
    public void testTurnRight2() {
        car.setCurDir(Car.Dir.DOWN);
        car.turnRight();
        assertTrue(car.getCurDir() == Car.Dir.LEFT);
    }

    @Test
    public void testTurnRight3() {
        car.setCurDir(Car.Dir.LEFT);
        car.turnRight();
        assertTrue(car.getCurDir() == Car.Dir.UP);
    }

    @Test
    public void testTurnRight4() {
        car.setCurDir(Car.Dir.UP);
        car.turnRight();
        assertTrue(car.getCurDir() == Car.Dir.RIGHT);
    }

    @Test
    public void testSpeedFactorSaab1() {
        assertTrue(car.speedFactor() == 1.25);
    }

    @Test
    public void testSpeedFactorSaab2() {
        car.setTurboOn();
        assertTrue(car.speedFactor() == 1.625);
    }

    @Test
    public void testSpeedFactorVolvo() {
        Volvo240 car2 = new Volvo240(Color.GREEN);
        assertTrue(car2.speedFactor() == 1.25);
    }
}
