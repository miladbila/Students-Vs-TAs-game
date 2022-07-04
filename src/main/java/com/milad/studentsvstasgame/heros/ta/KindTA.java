package com.milad.studentsvstasgame.heros.ta;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import javafx.scene.image.Image;

public class KindTA extends Hero {
    public KindTA(double XPosition, double YPosition) {
        super(4, 110, 8, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("KindTA.gif"));
        this.setImage(image);
    }

    @Override
    public Hero copy() {
        return null;
    }
}
