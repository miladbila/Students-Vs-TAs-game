package com.milad.studentsvstasgame.heros.student;

import com.milad.studentsvstasgame.HelloApplication;
import com.milad.studentsvstasgame.heros.Hero;
import com.milad.studentsvstasgame.heros.ta.HeadTA;
import javafx.scene.image.Image;

public class ClownStudent extends Hero {
    public ClownStudent(double XPosition, double YPosition) {
        super(-8, 110, 11, XPosition, YPosition);
        Image image=new Image(HelloApplication.class.getResourceAsStream("ClownStudent.gif"));
        this.setImage(image);
    }


    public Hero copy(){
        return new ClownStudent(getTranslateX(), getTranslateY());
    }
}
