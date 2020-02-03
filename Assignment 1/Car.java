import java.awt.*;

public abstract class Car implements Movable {

    private String modelName; // The car model name
    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car

    private double x;
    private double y;

    public enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Dir curDir;

    public Car(String modelName, int nrDoors, Color color, double enginePower) {
        this.modelName = modelName;
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.curDir = Dir.RIGHT;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed >= enginePower) {
            this.currentSpeed = enginePower;
        } else if (currentSpeed <= 0) {
            this.currentSpeed = 0;
        } else {
            this.currentSpeed = currentSpeed;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Dir getCurDir() {
        return curDir;
    }

    public void setCurDir(Dir curDir) {
        this.curDir = curDir;
    }

    public abstract double speedFactor();

    public void incrementSpeed(double amount) {
        double speed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        if (speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    public void decrementSpeed(double amount) {
        double speed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    public void gas(double amount) {
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    public void brake(double amount) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    @Override
    public void move() {
        if (curDir == Dir.RIGHT) {
            x += currentSpeed;
        } else if (curDir == Dir.LEFT) {
            x -= currentSpeed;
        } else if (curDir == Dir.UP) {
            y += currentSpeed;
        } else if (curDir == Dir.DOWN) {
            y -= currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        if (curDir == Dir.RIGHT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.UP) {
            curDir = Dir.LEFT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.RIGHT;
        }
    }

    @Override
    public void turnRight() {
        if (curDir == Dir.RIGHT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.UP) {
            curDir = Dir.RIGHT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.LEFT;
        }
    }
}