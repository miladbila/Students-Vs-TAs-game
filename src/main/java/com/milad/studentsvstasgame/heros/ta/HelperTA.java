package com.milad.studentsvstasgame.heros.ta;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import javafx.scene.image.Image;

public class HelperTA extends Hero {
    public HelperTA(double XPosition, double YPosition) {
        super(10, 10, 10, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("HelperTA.gif"));
        this.setImage(image);
    }

    @Override
    public Hero copy() {
        return null;
    }
}
