package com.milad.studentsvstasgame.heros;

import javafx.scene.image.ImageView;

public abstract class Hero extends ImageView {
    private int speed;
    private int health;
    private int power;

    public Hero(int speed, int health, int power, double XPosition, double YPosition) {
        this.speed = speed;
        this.health = health;
        this.power = power;
        this.setTranslateX(XPosition);
        this.setTranslateY(YPosition);
        this.setFitHeight(110);
        this.setFitWidth(120);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    abstract public Hero copy();
}
