package com.milad.studentsvstasgame.heros.ta;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import javafx.scene.image.Image;

public class UselessTA extends Hero {
    public UselessTA(double XPosition, double YPosition) {
        super(3, 60, 7, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("UselessTA.gif"));
        this.setImage(image);
    }

    @Override
    public Hero copy() {
        return null;
    }
}
