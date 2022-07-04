package com.milad.studentsvstasgame.heros.ta;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import javafx.scene.image.Image;

public class HelperTA extends Hero {
    public HelperTA(double XPosition, double YPosition) {
        super(4, 70, 8, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("HelperTA.gif"));
        this.setImage(image);
    }

    @Override
    public Hero copy() {
        return null;
    }
}
