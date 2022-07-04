package com.milad.studentsvstasgame;

import com.milad.studentsvstasgame.heros.Hero;
import com.milad.studentsvstasgame.heros.student.ClownStudent;
import com.milad.studentsvstasgame.heros.student.NormalStudent;
import com.milad.studentsvstasgame.heros.student.StudiousStudent;
import com.milad.studentsvstasgame.heros.student.StupidStudent;
import com.milad.studentsvstasgame.heros.ta.HeadTA;
import com.milad.studentsvstasgame.heros.ta.KindTA;
import com.milad.studentsvstasgame.heros.ta.UselessTA;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;


public class GamePage extends Pane {
    Group heroes = new Group(new ClownStudent(0, 0), new NormalStudent(110, 0), new StudiousStudent(220, 0), new StupidStudent(330, 0));
    ArrayList<Hero> studentHeroes = new ArrayList<>();
    ArrayList<Hero> TAHeroes = new ArrayList<>();
    Timeline timeline;
    GamePage gamePage = this;
    int coin = 2;
    Label coinLabel = new Label();


    GamePage() {
        this.minHeight(1280);
        this.minWidth(720);
        Image backGroundImage = new Image(HelloApplication.class.getResourceAsStream("gameBackGround.png"));
        ImageView backGroundImageView = new ImageView(backGroundImage);
        this.getChildren().add(backGroundImageView);
        this.getChildren().add(heroes);
        coinLabel.setText("0");
        coinLabel.setTranslateY(20);
        coinLabel.setTranslateX(650);
        this.getChildren().add(coinLabel);
        dragAndDropHeroes();
        timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> updateGame()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        deployTA();

    }

    void updateCoin() {
        coin++;
        coinLabel.setText(String.valueOf(coin));
    }

    void decreaseCoin() {
        coin--;
        coinLabel.setText(String.valueOf(coin));
    }

    void updateGame() {
        ArrayList<Hero> temp1 = new ArrayList<>(studentHeroes);
        ArrayList<Hero> temp2 = new ArrayList<>(TAHeroes);
        for (Hero a : studentHeroes)
            for (Hero b : TAHeroes)
                if (a.getBoundsInParent().intersects(b.getBoundsInParent())) {
                    temp1.remove(a);
                    temp2.remove(b);
                    new Thread(() -> {
                        while (true) {
                            if (a.getHealth() <= 0) {
                                studentHeroes.remove(a);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        gamePage.getChildren().remove(a);
                                    }
                                });
                                break;
                            }
                            if (b.getHealth() <= 0) {
                                TAHeroes.remove(b);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        gamePage.getChildren().remove(b);
                                    }
                                });
                                break;
                            }
                            a.setHealth(a.getHealth() - b.getPower());
                            b.setHealth(b.getHealth() - a.getPower());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }).start();
                }

        for (Hero a : temp2) {
            a.setTranslateX(a.getTranslateX() + a.getSpeed());
            if (a.getTranslateX() > 1300) {
                timeline.stop();
                Stage primaryStage = new Stage();
                VBox root = null;
                try {
                    root = (VBox) FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene scene = new Scene(root, 800, 500);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        }
        for (Hero a : temp1) {
            a.setTranslateX(a.getTranslateX() + a.getSpeed());


        }
    }

        void dragAndDropHeroes() {
            for (Node a : heroes.getChildren()) {
                a.setOnMousePressed(e -> {
                    studentHeroes.add(((Hero) a).copy());
                    this.getChildren().add(studentHeroes.get(studentHeroes.size() - 1));
                });
                a.setOnMouseDragged(e -> {
                    studentHeroes.get(studentHeroes.size() - 1).setTranslateX(e.getSceneX());
                    studentHeroes.get(studentHeroes.size() - 1).setTranslateY(e.getSceneY());
                });
                a.setOnMouseReleased(e -> {
                    if (studentHeroes.get(studentHeroes.size() - 1).getTranslateY() < 130 || studentHeroes.get(studentHeroes.size() - 1).getTranslateY() > 610
                            || studentHeroes.get(studentHeroes.size() - 1).getTranslateX() < 80 || studentHeroes.get(studentHeroes.size() - 1).getTranslateX() > 1200
                            || coin < 1) {
                        studentHeroes.get(studentHeroes.size() - 1).setVisible(false);
                        this.getChildren().remove(studentHeroes.get(studentHeroes.size() - 1));
                        studentHeroes.remove(studentHeroes.get(studentHeroes.size() - 1));
                    } else {
                        gamePage.decreaseCoin();
                        if (studentHeroes.get(studentHeroes.size() - 1).getTranslateY() > 130 && studentHeroes.get(studentHeroes.size() - 1).getTranslateY() < 290) {
                            studentHeroes.get(studentHeroes.size() - 1).setTranslateY(170);
                        } else if (studentHeroes.get(studentHeroes.size() - 1).getTranslateY() > 290 && studentHeroes.get(studentHeroes.size() - 1).getTranslateY() < 460) {
                            studentHeroes.get(studentHeroes.size() - 1).setTranslateY(330);
                        } else {
                            studentHeroes.get(studentHeroes.size() - 1).setTranslateY(480);
                        }
                    }
                });
            }
        }

        void deployTA () {
            new Thread(() -> {
                Hero temp = new KindTA(150, 170);
                TAHeroes.add(temp);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        gamePage.getChildren().add(TAHeroes.get(TAHeroes.size() - 1));
                        gamePage.updateCoin();
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                temp = new HeadTA(160, 480);
                TAHeroes.add(temp);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        gamePage.getChildren().add(TAHeroes.get(TAHeroes.size() - 1));
                        gamePage.updateCoin();
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                temp = new UselessTA(150, 330);
                TAHeroes.add(temp);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        gamePage.getChildren().add(TAHeroes.get(TAHeroes.size() - 1));
                        gamePage.updateCoin();
                    }
                });
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                timeline.stop();
                Stage primaryStage = new Stage();
                AnchorPane root = null;
                try {
                    root = (AnchorPane) FXMLLoader.load(HelloApplication.class.getResource("winner.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Scene scene = new Scene(root, 800, 500);
                primaryStage.setScene(scene);
                primaryStage.show();
                    }
                });
            }).start();

        }
    }
