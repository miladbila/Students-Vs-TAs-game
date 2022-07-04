package com.milad.studentsvstasgame.heros.student;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import com.milad.studentsvstasgame.heros.ta.HeadTA;
import javafx.scene.image.Image;

public class StupidStudent extends Hero {
    public StupidStudent(double XPosition, double YPosition) {
        super(-7, 90, 15, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("StupidStudent.gif"));
        this.setImage(image);
    }

    public Hero copy(){
        return new StupidStudent(getTranslateX(), getTranslateY());
    }
}
