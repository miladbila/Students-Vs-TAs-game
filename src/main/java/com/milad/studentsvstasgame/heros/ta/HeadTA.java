package com.milad.studentsvstasgame.heros.ta;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import javafx.scene.image.Image;

public class HeadTA extends Hero {
    public HeadTA(double XPosition, double YPosition) {
        super(10, 100, 10, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("HeadTA.gif"));
        this.setImage(image);
    }

    @Override
    public Hero copy() {
        return null;
    }
}
