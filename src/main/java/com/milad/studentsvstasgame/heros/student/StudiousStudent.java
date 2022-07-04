package com.milad.studentsvstasgame.heros.student;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import com.milad.studentsvstasgame.heros.ta.HeadTA;
import javafx.scene.image.Image;

public class StudiousStudent extends Hero {
    public StudiousStudent(double XPosition, double YPosition) {
        super(-10, 80, 10, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("StudiousStudent.gif"));
        this.setImage(image);
    }

    public Hero copy(){
        return new StudiousStudent(getTranslateX(), getTranslateY());
    }
}
